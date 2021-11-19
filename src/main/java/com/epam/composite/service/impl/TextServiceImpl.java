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
        paragraphs = paragraphs.stream()
                .sorted(Comparator.comparingInt(paragraph -> paragraph.findSize()))
                .collect(Collectors.toList());
        TextComponent result = new TextComposite(TextComponentType.TEXT);
        paragraphs.forEach(result::add);
        return result;
    }

    @Override
    public TextComponent findSentencesWithLongestWord(TextComponent text) {
        int longestWordSize = 0;
        TextComponent sentencesWithLongestWord = text.getChildren().get(0);
        for (TextComponent paragraph : text.getChildren()){
            for (TextComponent sentence : paragraph.getChildren()){
                int longestWordInSentenceSize = findLongesWordSize(sentence);
                if (longestWordInSentenceSize > longestWordSize){
                    longestWordSize = longestWordInSentenceSize;
                    sentencesWithLongestWord = sentence;
                }
            }
        }
        return sentencesWithLongestWord;
    }
    @Override
    public TextComponent deleteSentencesWithLessWordsAmount(TextComponent text, int wordAmount) {
        TextComponent textCopy = text.getCopy();
        textCopy.getChildren()
                .forEach(paragraph -> paragraph.getChildren()
                        .forEach(sentence -> {
                            if (findWordAmount(sentence) < wordAmount){
                                paragraph.remove(sentence);
                            }
                        }));
        return textCopy;
    }

    @Override
    public Map<String, Integer> findRepeatedWordsAmount(TextComponent text) {
        Map<String, Integer> result = new HashMap<>();
        text.getChildren()
                .forEach(paragraph -> paragraph.getChildren()
                        .forEach(sentence -> sentence.getChildren()
                                .forEach(lexeme -> lexeme.getChildren()
                                        .forEach(part -> {
                                            if(part.getType() == TextComponentType.WORD){
                                                if (result.containsKey(part.toString())){
                                                    result.put(part.toString(), result.get(part.toString()) + 1);
                                                }
                                                else {
                                                    result.put(part.toString(), 1);
                                                }
                                            }
                                        }))));
        result.entrySet().removeIf(word -> word.getValue() < 2);
        return result;
    }

    @Override
    public long findVowelsAmount(TextComponent sentence) {
        long count = sentence.getChildren().stream()
                .flatMap(lexems -> lexems.getChildren().stream())
                .flatMap(part -> part.getChildren().stream())
                .map(TextComponent::toString)
                .filter(symbol -> symbol.matches(VOWEL_PATTERN))
                .count();
        return count;
    }

    @Override
    public long findConsonantsAmount(TextComponent sentence) {
        long count = sentence.getChildren().stream()
                .flatMap(lexems -> lexems.getChildren().stream())
                .flatMap(part -> part.getChildren().stream())
                .map(TextComponent::toString)
                .filter(symbol -> symbol.matches(VOWEL_PATTERN))
                .count();
        return count;
    }

    private int findLongesWordSize(TextComponent sentence){
        int longestWordSize = 0;
        for (TextComponent sentenceComponent : sentence.getChildren()){
            if (sentenceComponent instanceof TextComposite){
                for (TextComponent lexemeComponent : sentenceComponent.getChildren()){
                    if (lexemeComponent instanceof TextComposite){
                        if (lexemeComponent.findSize() > longestWordSize){
                            longestWordSize = lexemeComponent.findSize();
                        }
                    }
                }
            }
        }
        return longestWordSize;
    }

    private int findWordAmount(TextComponent sentence){
        int wordAmount = (int) sentence.getChildren().stream()
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(part -> part.getType() == TextComponentType.WORD).count();
        return wordAmount;
    }
}
