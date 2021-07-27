package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;

public class Toggle extends CustomFormElement {

    @SerializedName("default") protected final boolean defaultValue;
    protected transient boolean takenValue;

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

    public boolean getValue(){
        return takenValue;
    }

    @Override
    public void respond(Object value) {
        takenValue = (boolean) value;
    }

}
