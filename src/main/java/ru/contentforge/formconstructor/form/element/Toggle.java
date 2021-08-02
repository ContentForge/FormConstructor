package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Toggle extends CustomFormElement {

    @SerializedName("default") protected final boolean defaultValue;
    protected transient boolean value;

    public Toggle(){
        this("");
    }

    public Toggle(String name){
        this(name, false);
    }

    public Toggle(String name, boolean defaultValue) {
        super(name, "toggle");

        this.defaultValue = defaultValue;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void respond(Object value) {
        this.value = (boolean) value;
    }

}
