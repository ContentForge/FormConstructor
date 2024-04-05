package ru.contentforge.formconstructor.form;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.element.Button;
import ru.contentforge.formconstructor.form.handler.OnCloseFormHandler;
import ru.contentforge.formconstructor.form.response.SimpleFormResponse;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleForm extends CloseableForm {

    @SerializedName("type") protected final String type = "form";
    @Getter @SerializedName("title") protected String title;
    @Getter @SerializedName("content") protected String content;
    @Getter @SerializedName("buttons") protected ArrayList<Button> buttons = new ArrayList<>();
    @Getter protected transient SimpleFormResponse response = null;

    public SimpleForm(){
        this("");
    }

    public SimpleForm(String title){
        this(title, "");
    }

    public SimpleForm(String title, String content){
        this(title, content,null);
    }

    public SimpleForm(String title, String content, OnCloseFormHandler noneHandler){
        this(title, content, noneHandler, null);
    }

    public SimpleForm(String title, String content, OnCloseFormHandler noneHandler, Collection<Button> buttons){
        this.title = title;
        this.content = content;
        this.onCloseHandler = noneHandler;

        if(buttons == null) return;
        for(Button button: buttons) add(button);
    }

    public SimpleForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public SimpleForm setContent(String content) {
        this.content = content;
        return this;
    }

    public SimpleForm addContent(String addition){
        this.content += addition;
        return this;
    }

    public SimpleForm add(Button button){
        buttons.add(button);
        return this;
    }

    public SimpleForm add(Button... buttons){
        for(Button button: buttons) add(button);
        return this;
    }

    public SimpleForm add(Collection<Button> buttons){
        for(Button button: buttons) add(button);
        return this;
    }

    @Override
    public void setResponse(String data) {
        if(data.equals("null")) return;

        int buttonId;
        try {
            buttonId = Integer.parseInt(data);
        } catch (Exception var4) {
            return;
        }
        if(buttonId >= buttons.size() || buttonId < 0){
            response = new SimpleFormResponse(new Button("Invalid", (p, b) -> send(p)));
            return;
        }

        for(int i = 0; i < buttons.size(); i++) buttons.get(i).index = i;

        response = new SimpleFormResponse(buttons.get(buttonId));
    }
}
