package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.SimpleFormHandler;

public class Button extends FormElement {

    @Getter @SerializedName("image") protected ImageButton image;
    @Getter protected transient SimpleFormHandler handler;

    public Button(){
        this("");
    }

    public Button(String name){
        this(name, null);
    }

    public Button(String name, SimpleFormHandler handler){
        this(name, ImageType.PATH, "", handler);
    }

    public Button(String name, ImageType imageType, String image){
        this(name, imageType, image, null);
    }

    public Button(String name, ImageType imageType, String image, SimpleFormHandler handler) {
        super(name);

        this.handler = handler;
        this.image = new ImageButton(imageType, image);
    }

}
