package ru.ibs.recruiters_happiness.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ibs.recruiters_happiness.auth.db.DbApplicationUserService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackageClasses = DbApplicationUserService.class)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Qualifier("AppUserService")
    private final DbApplicationUserService ApplicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     DbApplicationUserService ApplicationUserService
                                     ) {
        this.passwordEncoder = passwordEncoder;
        this.ApplicationUserService = ApplicationUserService;
    }

    //TODO Надо добавить конфигурацию на основе формы после готовночти Фронта
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/hrdream/projects/**").permitAll()
                .antMatchers(HttpMethod.GET, "/hrdream/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .cors();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(ApplicationUserService);
        return provider;
    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails productManager = User.builder()
//                .username("ProductManager")
//                .password(passwordEncoder.encode("12345"))
//                .authorities(PM.getAuthorities())
//                .build();
//
//        UserDetails headRecruiter = User.builder()
//                .username("HeadRecruiter")
//                .password(passwordEncoder.encode("12345"))
//                .authorities(HR.getAuthorities())
//                .build();
//
//        UserDetails devManager = User.builder()
//                .username("DevManager")
//                .password(passwordEncoder.encode("12345"))
//                .authorities(DM.getAuthorities())
//                .build();
//        return new InMemoryUserDetailsManager(productManager, headRecruiter, devManager);
//    }
}
