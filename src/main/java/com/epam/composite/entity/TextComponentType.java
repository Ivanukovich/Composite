package com.epam.composite.entity;

public enum TextComponentType {
    TEXT("\n\t"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(" "),
    WORD(""),
    LETTER(""),
    DIGIT(""),
    PUNCTUATION("");

    private final String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
