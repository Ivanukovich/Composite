package com.epam.composite.parser.impl;

import com.epam.composite.entity.Symbol;
import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.parser.TextComponentParser;

public class WordParser implements TextComponentParser {
    @Override
    public TextComponent parse(String word) {
        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
        TextComponent symbolComponent;
        char[] symbols = word.toCharArray();
        for (char symbol : symbols){
            if (Character.isDigit(symbol)){
                symbolComponent = new Symbol(symbol, TextComponentType.DIGIT);
            }
            else {
                symbolComponent = new Symbol(symbol, TextComponentType.LETTER);
            }
            wordComposite.add(symbolComponent);
        }
        return wordComposite;
    }
}
