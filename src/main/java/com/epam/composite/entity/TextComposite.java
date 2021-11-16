package com.epam.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final TextComponentType type;
    private final List<TextComponent> components;

    public TextComposite(TextComponentType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    @Override
    public void add(TextComponent textComponent) {
        components.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        components.remove(textComponent);
    }

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public int findSize() {
        return components.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (TextComponent component : components){
            result.append(component.toString());
            result.append(type.getDelimiter());
        }
        return String.valueOf(result);
    }
}
