package ru.contentforge.formconstructor.form.element.validator;

public class RegexValidator extends Validator {

    private final String regex;

    public RegexValidator(String name, String regex) {
        super(name);

        this.regex = regex;
    }

    @Override
    public void validate(String input) {
        validated = input.matches(regex);
    }

}
