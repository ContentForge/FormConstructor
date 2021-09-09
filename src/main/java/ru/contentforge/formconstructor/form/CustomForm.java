package ru.contentforge.formconstructor.form;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.element.CustomFormElement;
import ru.contentforge.formconstructor.form.element.validator.ValidationField;
import ru.contentforge.formconstructor.form.handler.CustomFormHandler;
import ru.contentforge.formconstructor.form.response.CustomFormResponse;

import java.util.ArrayList;
import java.util.HashSet;

public class CustomForm extends CloseableForm {

    @SerializedName("type") protected final String type = "custom_form";
    @Getter @SerializedName("title") protected String title;
    @SerializedName("content") protected ArrayList<CustomFormElement> elements = new ArrayList<>();
    @Getter protected transient CustomFormResponse response = null;
    protected transient CustomFormHandler handler;
    protected final transient HashSet<String> containsId = new HashSet<>();
    @Getter protected transient boolean validated = true;

    public CustomForm(){
        this("", null);
    }

    public CustomForm(String name){
        this(name, null);
    }

    public CustomForm(CustomFormHandler handler){
        this("", handler);
    }

    public CustomForm(String title, CustomFormHandler handler){
        this.title = title;
        this.handler = handler;
    }

    public CustomForm setTitle(String title){
        this.title = title;
        return this;
    }

    public CustomForm addElement(CustomFormElement element){
        element.index = elements.size();
        elements.add(element);
        return this;
    }

    public CustomForm addElement(String elementId, CustomFormElement element){
        element.elementId = elementId;
        containsId.add(elementId);
        return addElement(element);
    }

    public CustomForm setHandler(CustomFormHandler handler){
        this.handler = handler;
        return this;
    }

    @Override
    public void setResponse(String data) {
        if(data.equals("null")) return;

        Object[] result = new Gson().fromJson(data, Object[].class);
        for (int i = 0; i < elements.size(); i++){
            CustomFormElement element = elements.get(i);
            if(!element.respond(result[i])){
                response = new CustomFormResponse((p, r) -> send(p), elements, containsId);
                return;
            }

            if(element instanceof ValidationField){
                if(validated && !((ValidationField) element).getValidatorResult()) validated = false;
            }
        }

        response = new CustomFormResponse(handler, elements, containsId);
    }

}
