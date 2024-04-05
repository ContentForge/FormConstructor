package ru.contentforge.formconstructor.form.response;

import cn.nukkit.Player;
import ru.contentforge.formconstructor.form.element.Button;
import ru.contentforge.formconstructor.form.handler.ButtonClickHandler;

public class SimpleFormResponse extends Response<ButtonClickHandler> {

    protected Button button;

    public SimpleFormResponse(Button button) {
        super(button.getHandler(), "");

        this.button = button;
    }

    @Override
    public void handle(Player player) {
        if(handler == null) return;
        handler.handle(player, button);
    }
}
