package com.epam.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent{
    private static final Logger logger = LogManager.getLogger();
    private final TextComponentType type;
    private char value;

    public Symbol(char value, TextComponentType type){
        this.value = value;
        this.type = type;
    }

    public TextComponentType getType() {
        return type;
    }

    public char getValue(){
        return value;
    }

    @Override
    public TextComponent getCopy() {
        return new Symbol(this.value, this.type);
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
        return String.valueOf(value);
    }

}
