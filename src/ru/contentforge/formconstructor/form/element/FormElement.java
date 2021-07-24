package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;

abstract public class FormElement {

    @SerializedName("text") protected String name;
    public transient int index = -1;

    public FormElement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
