package ru.contentforge.formconstructor.form;

import lombok.Getter;
import ru.contentforge.formconstructor.form.handler.NoneHandler;

abstract public class CloseableForm extends Form {


    @Getter protected transient NoneHandler noneHandler = null;

    public CloseableForm setNoneHandler(NoneHandler noneHandler) {
        this.noneHandler = noneHandler;
        return this;
    }

}
