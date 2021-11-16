package com.epam.composite.service.impl;

import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.service.TextService;


import java.util.*;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    private static final String VOWEL_PATTERN = "[aeiouyаеёиоуыэюяAEIOUYАЕЁИОУЫЭЮЯ]";

    @Override
    public TextComponent sortParagraphs(TextComponent text){
        List<TextComponent> paragraphs = text.getChildren();
        paragraphs.stream()
                .sorted(Comparator.comparingInt(paragraph -> paragraph.findSize()))
                .collect(Collectors.toList());
        TextComponent result = new TextComposite(TextComponentType.TEXT);
        paragraphs.forEach(result::add);
        return result;
    }

    @Override
    public TextComponent findSentencesWithLongestWord(TextComponent text) {
        return null;
    }

    @Override
    public TextComponent deleteSentencesWithLessWordsAmount(TextComponent text, int wordAmount) {
        return null;
    }

    @Override
    public Map<String, Integer> findRepeatedWordsAmount(TextComponent text) {
        return null;
    }

    @Override
    public long findVowelsAmount(TextComponent sentence) {
        long count = sentence.getChildren().stream()
                .flatMap(c -> c.getChildren().stream())
                .flatMap(c -> c.getChildren().stream())
                .map(TextComponent::toString)
                .filter(c -> c.matches(VOWEL_PATTERN))
                .count();
        return count;
    }

    @Override
    public long findConsonantsAmount(TextComponent sentence) {
        long count = sentence.getChildren().stream()
                .flatMap(c -> c.getChildren().stream())
                .flatMap(c -> c.getChildren().stream())
                .map(TextComponent::toString)
                .filter(c -> c.matches(VOWEL_PATTERN))
                .count();
        return count;
    }
}
