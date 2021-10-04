package ru.contentforge.formconstructor;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.plugin.PluginBase;
import ru.contentforge.formconstructor.form.Form;
import ru.contentforge.formconstructor.task.FormHandlingAsyncTask;

public class FormConstructor extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    void onFormResponded(PlayerFormRespondedEvent event){
        if(!(event.getWindow() instanceof Form)) return;

        getServer().getScheduler().scheduleAsyncTask(this, new FormHandlingAsyncTask(
                event.getResponse(),
                (Form) event.getWindow(),
                event.getPlayer()
        ));
    }

}
