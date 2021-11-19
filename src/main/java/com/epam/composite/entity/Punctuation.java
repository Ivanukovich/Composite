package com.epam.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Punctuation implements TextComponent {
    private static final Logger logger = LogManager.getLogger();
    private char sign;

    public Punctuation(char sign){
        this.sign = sign;
    }

    public char getSign(){
        return sign;
    }

    public TextComponentType getType() {
        return TextComponentType.PUNCTUATION;
    }

    @Override
    public TextComponent getCopy() {
        return new Punctuation(this.sign);
    }

    @Override
    public void add(TextComponent textComponent){
        logger.error("");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent){
        logger.error("");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.error("");
        throw new UnsupportedOperationException();
    }

    @Override
    public int findSize() {
        logger.error("");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(sign);
    }
}
