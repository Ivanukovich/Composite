package com.epam.composite.parser.impl;

import com.epam.composite.entity.Punctuation;
import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.parser.TextComponentParser;

public class SentenceParser implements TextComponentParser {
    private static final String LEXEME_DELIMITER = "\\s+|[.?!…]";
    private static final LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String sentence) {
        String []lexemes = sentence.split(LEXEME_DELIMITER);
        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
        for(String lexem : lexemes){
            TextComponent lexemeComponent = lexemeParser.parse(lexem);
            sentenceComposite.add(lexemeComponent);
        }
        Punctuation sign = new Punctuation(sentence.charAt(sentence.length()-1));
        sentenceComposite.add(sign);
        return sentenceComposite;
    }
}
