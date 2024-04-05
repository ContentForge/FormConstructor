package ru.contentforge.formconstructor.form.element;

import lombok.Getter;

public class SelectableElement {

    @Getter private final String text;
    @Getter private final Object value;
    public int index = -1;

    public SelectableElement(String text){
        this(text, null);
    }

    public SelectableElement(String text, Object value){
        this.text = text;
        this.value = value;
    }

    public <T> T getValue(Class<T> clazz) {
        return clazz.cast(value);
    }
}
