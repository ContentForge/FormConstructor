package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ImageButton {

    @SerializedName("type") protected ImageType type;
    @SerializedName("data") protected String path;

    public ImageButton(){
        this(ImageType.PATH, "");
    }

    public ImageButton(ImageType type, String path){
        this.path = path;
        this.type = type;
    }
}
