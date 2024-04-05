package ru.contentforge.formconstructor.form;

import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.NoneHandler;

@Getter
abstract public class CloseableForm extends Form {

    protected transient NoneHandler noneHandler = null;

    public CloseableForm setNoneHandler(NoneHandler noneHandler) {
        this.noneHandler = noneHandler;
        return this;
    }
}
