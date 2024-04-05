package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

abstract public class FormElement {

    @Getter
    @SerializedName("text") protected String name;
    public transient int index = -1;

    public FormElement(String name){
        this.name = name;
    }
}
