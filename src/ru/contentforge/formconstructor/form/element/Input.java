package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;

public class Input extends CustomFormElement {

    @SerializedName("placeholder") protected final String placeholder;
    @SerializedName("default") protected final String defaultValue;
    protected transient String takenValue;

    public Input(){
        this("");
    }

    public Input(String name){
        this(name, "");
    }

    public Input(String name, String placeholder){
        this(name, placeholder, "");
    }

    @Override
    public void respond(Object value) {
        takenValue = (String) value;
    }

    public Input(String name, String placeholder, String defaultValue) {
        super(name, "input");

        this.placeholder = placeholder;
        this.defaultValue = defaultValue;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getValue() {
        return takenValue;
    }

}
