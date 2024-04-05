package ru.contentforge.formconstructor.form.response;

import cn.nukkit.Player;
import ru.contentforge.formconstructor.form.handler.ModalFormHandler;

public class ModalFormResponse extends Response<ModalFormHandler> {

    public ModalFormResponse(ModalFormHandler handler, String data) {
        super(handler, data);
    }

    @Override
    public void handle(Player player) {
        if(handler == null) return;
        handler.handle(player, data.equals("true"));
    }
}
