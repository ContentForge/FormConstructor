package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;

abstract public class CustomFormElement extends FormElement {

    @SerializedName("type") protected final String type;
    public transient String elementId = null;
    public transient int elementIndex = -1;

    public CustomFormElement(String name, String type) {
        super(name);

        this.type = type;
    }

    public abstract boolean respond(Object value);

}
