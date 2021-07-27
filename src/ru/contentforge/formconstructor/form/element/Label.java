package ru.contentforge.formconstructor.form.element;

public class Label extends CustomFormElement {

    public Label(){
        this("");
    }

    public Label(String text) {
        super(text, "label");
    }

    @Override
    public void respond(Object value) {

    }

}
