package ru.contentforge.formconstructor.form.element;

public class SelectableElement {

    private final String text;
    private final Object value;
    public int index = -1;

    public SelectableElement(String text){
        this(text, null);
    }

    public SelectableElement(String text, Object value){
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public Object getValue() {
        return value;
    }

    public <T> T getValue(Class<T> clazz) {
        return clazz.cast(value);
    }

}
