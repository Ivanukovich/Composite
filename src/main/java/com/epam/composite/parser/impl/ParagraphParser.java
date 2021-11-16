package com.epam.composite.parser.impl;

import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.parser.TextComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements TextComponentParser {
    private static final String SENTENCE_PATTERN = "";
    private static final SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComponent parse(String paragraph) {
        Pattern sentencePattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher sentenceMathcer = sentencePattern.matcher(paragraph);
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
        while(sentenceMathcer.find()){
            String sentence = sentenceMathcer.group();
            TextComponent sentenceComponent = sentenceParser.parse(sentence);
            paragraphComposite.add(sentenceComponent);
        }
        return paragraphComposite;
    }
}
