package ru.contentforge.formconstructor.form;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindow;
import lombok.Getter;

abstract public class Form extends FormWindow {

    @Getter protected transient boolean async = false;

    public void send(Player player){
        async = false;
        player.showFormWindow(this);
    }

    public void sendAsync(Player player){
        async = true;
        player.showFormWindow(this);
    }

}
