package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Input extends CustomFormElement {

    @Getter @SerializedName("placeholder") protected final String placeholder;
    @Getter @SerializedName("default") protected final String defaultValue;
    @Getter protected transient String value;

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
        this.value = (String) value;
    }

    public Input(String name, String placeholder, String defaultValue) {
        super(name, "input");

        this.placeholder = placeholder;
        this.defaultValue = defaultValue;
    }

}
