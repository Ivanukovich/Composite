package com.epam.composite.service;

import com.epam.composite.entity.TextComponent;
import com.epam.composite.exception.CompositeException;

import java.util.List;
import java.util.Map;

public interface TextService {
    TextComponent sortParagraphs(TextComponent text) throws CompositeException;

    TextComponent findSentencesWithLongestWord(TextComponent text);

    TextComponent deleteSentencesWithLessWordsAmount(TextComponent text, int wordAmount);

    Map<String, Integer> findRepeatedWordsAmount(TextComponent text);

    long findVowelsAmount(TextComponent sentence);

    long findConsonantsAmount(TextComponent sentence);
}
