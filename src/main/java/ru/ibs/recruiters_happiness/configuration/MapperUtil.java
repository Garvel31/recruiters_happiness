package ru.ibs.recruiters_happiness.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.entities.dto.ProjectInfoPageDTO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MapperUtil {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
    public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }

    public static Project DtoToEntityConv(ProjectDTO projectDto, ModelMapper modelMapper) {
        return modelMapper.map(projectDto, Project.class);
    }

    public static ProjectDTO entityToDtoConv(Project project, ModelMapper modelMapper) {
        return modelMapper.map(project, ProjectDTO.class);
    }


}
