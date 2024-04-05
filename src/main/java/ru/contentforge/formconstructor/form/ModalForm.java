package ru.contentforge.formconstructor.form;

import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.ModalFormHandler;
import ru.contentforge.formconstructor.form.response.ModalFormResponse;

public class ModalForm extends Form {

    @SerializedName("type") private final String type = "modal";
    @SerializedName("title") String title;
    @SerializedName("content") String content;
    @SerializedName("button1") String positiveButton;
    @SerializedName("button2") protected String negativeButton;
    protected transient ModalFormHandler handler;
    @Getter protected transient ModalFormResponse response = null;

    public ModalForm(){
        this("");
    }

    public ModalForm(String title){
        this(title, "");
    }

    public ModalForm(String title, String content){
        this(title, content, "");
    }

    public ModalForm(String title, String content, String positiveButton){
        this(title, content, positiveButton, "");
    }

    public ModalForm(String title, String content, String positiveButton, String negativeButton){
        this(title, content, positiveButton, negativeButton, null);
    }

    public ModalForm(String title, String content, String positiveButton, String negativeButton, ModalFormHandler handler){
        this.title = title;
        this.content = content;
        this.positiveButton = positiveButton;
        this.negativeButton = negativeButton;
        this.handler = handler;
    }

    public ModalForm setTitle(String title){
        this.title = title;
        return this;
    }

    public ModalForm setContent(String content){
        this.content = content;
        return this;
    }

    public ModalForm addContent(String addition){
        this.content += addition;
        return this;
    }

    public ModalForm setPositiveButton(String text){
        this.positiveButton = text;
        return this;
    }

    public ModalForm setNegativeButton(String text){
        this.negativeButton = text;
        return this;
    }

    public ModalForm setHandler(ModalFormHandler handler){
        this.handler = handler;
        return this;
    }

    @Override
    public void setResponse(String data) {
        if (data.equals("null") || handler == null) return;

        response = new ModalFormResponse(handler, data);
    }

    public void send(Player player, ModalFormHandler handler){
        setHandler(handler);
        send(player);
    }
}
