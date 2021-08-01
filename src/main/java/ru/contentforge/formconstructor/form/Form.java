package ru.contentforge.formconstructor.form;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindow;

abstract public class Form extends FormWindow {

    public void send(Player player){
        player.showFormWindow(this);
    }

}
