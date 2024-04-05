package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Input extends CustomFormElement {

    @SerializedName("placeholder") protected final String placeholder;
    @SerializedName("default") protected final String defaultValue;
    protected transient String value;

    public Input(String name){
        this(name, "");
    }

    public Input(String name, String placeholder){
        this(name, placeholder, "");
    }

    public Input(String name, String placeholder, String defaultValue) {
        super(name, "input");

        this.placeholder = placeholder;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean respond(Object value) {
        this.value = (String) value;
        return true;
    }
}
