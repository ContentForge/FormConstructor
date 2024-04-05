package ru.contentforge.formconstructor.form.element;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.ButtonClickHandler;

@Getter
public class Button extends FormElement {

    @SerializedName("image") protected Icon image;
    protected transient ButtonClickHandler handler;

    public Button(String name, ButtonClickHandler handler){
        this(name, Icon.texture(""), handler);
    }

    public Button(String name, Icon icon, ButtonClickHandler handler) {
        super(name);

        this.handler = handler;
        this.image = icon;
    }

    public static class Icon {

        @SerializedName("type") protected Type type;
        @SerializedName("data") protected String path;

        private Icon(Type type, String path){
            this.path = path;
            this.type = type;
        }

        public static Icon texture(String path) {
            return new Icon(Type.PATH, path);
        }

        public static Icon url(String url) {
            return new Icon(Type.URL, url);
        }

        public enum Type {

            @SerializedName("path") PATH,
            @SerializedName("url") URL,
        }
    }
}
