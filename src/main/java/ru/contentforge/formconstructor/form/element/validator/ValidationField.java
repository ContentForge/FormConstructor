package ru.contentforge.formconstructor.form.element.validator;

import java.util.List;

public interface ValidationField {

    void validate();
    boolean getValidatorResult();
    List<Validator> getValidators();
    ValidationField addValidator(Validator validator);

}
