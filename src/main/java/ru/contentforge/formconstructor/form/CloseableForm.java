package ru.contentforge.formconstructor.form;

import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.OnCloseFormHandler;

@Getter
abstract public class CloseableForm extends Form {

    protected transient OnCloseFormHandler onCloseHandler = null;

    public CloseableForm setOnCloseHandler(OnCloseFormHandler onCloseHandler) {
        this.onCloseHandler = onCloseHandler;
        return this;
    }
}
