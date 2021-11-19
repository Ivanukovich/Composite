package com.epam.composite.entity;

import java.util.List;

public interface TextComponent {

    TextComponent getCopy();

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    List<TextComponent> getChildren();

    int findSize();

    TextComponentType getType();

    String toString();
}
