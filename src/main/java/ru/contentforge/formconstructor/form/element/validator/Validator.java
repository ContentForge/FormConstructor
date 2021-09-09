package ru.contentforge.formconstructor.form.element.validator;

import lombok.Getter;

public abstract class Validator {

    @Getter protected final String name;
    @Getter protected boolean validated;

    public Validator(String name){
        this.name = name;
    }

    public abstract void validate(String input);

}
