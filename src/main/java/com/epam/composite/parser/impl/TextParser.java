package com.epam.composite.parser.impl;

import com.epam.composite.entity.TextComponent;
import com.epam.composite.entity.TextComponentType;
import com.epam.composite.entity.TextComposite;
import com.epam.composite.parser.TextComponentParser;

public class TextParser implements TextComponentParser {
    private static final String PARAGRAPH_DELIMITER = "\\r\\t";
    private static final ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String text) {
        String []paragraphs = text.split(PARAGRAPH_DELIMITER);
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);
        for(String paragraph : paragraphs){
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComposite.add(paragraphComponent);
        }
        return textComposite;
    }
}
