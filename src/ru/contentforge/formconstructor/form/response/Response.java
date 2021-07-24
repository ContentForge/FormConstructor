package ru.contentforge.formconstructor.form.response;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponse;
import ru.contentforge.formconstructor.form.handler.FormHandler;

abstract public class Response <T extends FormHandler> extends FormResponse {

    protected final String data;
    protected final T handler;

    public Response(T handler, String data){
        this.handler = handler;
        this.data = data;
    }

    public abstract void handle(Player player);

}
