package com.epam.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements TextComponent{
    private static final Logger logger = LogManager.getLogger();
    private char value;

    public Symbol(char value){
        this.value = value;
    }

    public char getValue(){
        return value;
    }

    @Override
    public void add(TextComponent textComponent){
    }

    @Override
    public void remove(TextComponent textComponent){
    }

}
