package com.epam.composite.parser.impl;

import com.epam.composite.entity.Punctuation;
import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.parser.TextComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextComponentParser {
    private static final String WORD_PATTERN = "[\\w[А-Яа-яA-Za-z0-9]]+";
    private static final String WORD_OR_PUNCTUATION_PATTERN = "[\\w[А-Яа-яA-Za-z0-9]]+|\\p{Punct}";
    private static final WordParser wordParser = new WordParser();

    @Override
    public TextComponent parse(String data) {
        Pattern componentPattern = Pattern.compile(WORD_OR_PUNCTUATION_PATTERN);
        Pattern wordPattern = Pattern.compile(WORD_PATTERN);
        Matcher componentMatcher = componentPattern.matcher(data);
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
        while(componentMatcher.find()){
            String component = componentMatcher.group();
            Matcher wordMatcher = wordPattern.matcher(component);
            if(wordMatcher.matches()){
                TextComponent word = wordParser.parse(component);
                lexeme.add(word);
            }
            else {
                Punctuation sign = new Punctuation(component.charAt(0));
                lexeme.add(sign);
            }
        }
        return lexeme;
    }
}
