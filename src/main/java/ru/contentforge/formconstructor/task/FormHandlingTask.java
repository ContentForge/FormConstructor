package ru.contentforge.formconstructor.task;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.scheduler.AsyncTask;
import ru.contentforge.formconstructor.form.CloseableForm;
import ru.contentforge.formconstructor.form.Form;
import ru.contentforge.formconstructor.form.handler.OnCloseFormHandler;
import ru.contentforge.formconstructor.form.response.CustomFormResponse;
import ru.contentforge.formconstructor.form.response.ModalFormResponse;
import ru.contentforge.formconstructor.form.response.SimpleFormResponse;

public class FormHandlingTask extends AsyncTask {

    private final FormResponse response;
    private final Form form;
    private final Player player;

    public FormHandlingTask(FormResponse response, Form form, Player player){
        this.response = response;
        this.form = form;
        this.player = player;
    }

    @Override
    public void onRun() {
        synchronized (form) {
            if (response instanceof ModalFormResponse) {
                ((ModalFormResponse) response).handle(player);
                return;
            }

            if (response == null && form instanceof CloseableForm) {
                OnCloseFormHandler noneHandler = ((CloseableForm) form).getOnCloseHandler();
                if (noneHandler != null) noneHandler.handle(player);
                return;
            }

            if (response instanceof SimpleFormResponse) {
                ((SimpleFormResponse) form.getResponse()).handle(player);
                return;
            }

            if (response instanceof CustomFormResponse) {
                ((CustomFormResponse) form.getResponse()).handle(player);
                return;
            }

            //...
        }
    }
}
