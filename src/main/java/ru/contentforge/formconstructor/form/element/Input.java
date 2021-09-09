package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.element.validator.ValidationField;
import ru.contentforge.formconstructor.form.element.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Input extends CustomFormElement implements ValidationField {

    @Getter @SerializedName("placeholder") protected final String placeholder;
    @Getter @SerializedName("default") protected final String defaultValue;
    @Getter protected transient String value;
    @Getter protected transient boolean trim;
    @Getter protected transient List<Validator> validators;

    @Deprecated
    public Input(){
        this("");
    }

    @Deprecated
    public Input(String name){
        this(name, "");
    }

    @Deprecated
    public Input(String name, String placeholder){
        this(name, placeholder, "");
    }

    @Deprecated
    public Input(String name, String placeholder, String defaultValue) {
        this(name, placeholder, defaultValue, false, new ArrayList<>());
    }

    private Input(String name, String placeholder, String defaultValue, boolean trim, List<Validator> validators) {
        super(name, "input");

        this.placeholder = placeholder;
        this.defaultValue = defaultValue;
        this.trim = trim;
        this.validators = validators;
    }

    @Override
    public boolean respond(Object value) {
        if(trim) this.value = ((String) value).trim();
        else this.value = (String) value;

        validate();

        return true;
    }

    @Override
    public void validate() {
        for(Validator validator: validators){
            validator.validate(value);
        }
    }

    @Override
    public boolean getValidatorResult() {
        for(Validator validator: validators){
            if(!validator.isValidated()) return false;
        }
        return true;
    }

    @Override
    public Input addValidator(Validator validator){
        this.validators.add(validator);
        return this;
    }

    public static InputBuilder builder() {
        return new InputBuilder();
    }

    public static class InputBuilder {
        private String name = "";
        private String placeholder = "";
        private String defaultValue = "";
        private boolean trim = false;
        private List<Validator> validators = new ArrayList<>();

        public InputBuilder setName(String name){
            this.name = name;
            return this;
        }

        public InputBuilder setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public InputBuilder setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public InputBuilder setTrim(boolean trim) {
            this.trim = trim;
            return this;
        }

        public InputBuilder setValidators(List<Validator> validators){
            this.validators = validators;
            return this;
        }

        public InputBuilder addValidator(Validator... validator){
            this.validators.addAll(Arrays.asList(validator));
            return this;
        }

        public Input build() {
            return new Input(name, placeholder, defaultValue, trim, validators);
        }

    }

}
