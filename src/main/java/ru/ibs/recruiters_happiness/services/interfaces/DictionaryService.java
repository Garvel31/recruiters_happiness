package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.Technology;

import java.util.List;

public interface DictionaryService {

    void parseToDict(String s);

    List<String> dictLinkedList();

}
