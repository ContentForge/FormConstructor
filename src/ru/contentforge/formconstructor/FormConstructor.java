package ru.contentforge.formconstructor;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.plugin.PluginBase;
import ru.contentforge.formconstructor.form.CloseableForm;
import ru.contentforge.formconstructor.form.Form;
import ru.contentforge.formconstructor.form.response.ModalFormResponse;
import ru.contentforge.formconstructor.form.response.SimpleFormResponse;

public class FormConstructor extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    void onFormResponded(PlayerFormRespondedEvent event){
        if(!(event.getWindow() instanceof Form)) return;

        FormResponse response = event.getResponse();
        Form form = (Form) event.getWindow();
        Player player = event.getPlayer();

        if(response instanceof ModalFormResponse){
            ((ModalFormResponse) response).handle(player);
            return;
        }

        if(response == null && form instanceof CloseableForm){
            ((CloseableForm) form).getNoneHandler().handle(player);
            return;
        }

        if(response instanceof SimpleFormResponse){
            ((SimpleFormResponse) form.getResponse()).handle(player);
            return;
        }

        //TODO: custom form
    }

}
