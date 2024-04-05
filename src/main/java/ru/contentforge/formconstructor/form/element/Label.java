package ru.contentforge.formconstructor.form.element;

public class Label extends CustomFormElement {

    public Label(String text) {
        super(text, "label");
    }

    @Override
    public boolean respond(Object value) {
        return true;
    }
}
