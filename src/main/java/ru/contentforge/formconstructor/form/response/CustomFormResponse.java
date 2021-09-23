package ru.contentforge.formconstructor.form.response;

import cn.nukkit.Player;
import lombok.Getter;
import ru.contentforge.formconstructor.form.CustomForm;
import ru.contentforge.formconstructor.form.element.*;
import ru.contentforge.formconstructor.form.element.validator.ValidationField;
import ru.contentforge.formconstructor.form.element.validator.Validator;
import ru.contentforge.formconstructor.form.handler.CustomFormHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomFormResponse extends Response<CustomFormHandler> {

    @Getter protected final CustomForm form;
    protected final ArrayList<CustomFormElement> elements;
    protected final HashSet<String> containsId;

    public CustomFormResponse(CustomFormHandler handler, ArrayList<CustomFormElement> elements, HashSet<String> containsId, CustomForm form) {
        super(handler, "");

        this.elements = elements;
        this.containsId = containsId;
        this.form = form;
    }

    public CustomFormElement get(int index){
        return elements.get(index);
    }

    public CustomFormElement get(String elementId){
        for(CustomFormElement element: elements){
            if(elementId.equals(element.elementId)) return element;
        }
        return null;
    }

    public boolean containsId(String elementId){
        return containsId.contains(elementId);
    }

    public <T extends CustomFormElement> T get(String elementId, Class<T> clazz){
        return clazz.cast(get(elementId));
    }

    public <T extends CustomFormElement> List<T> get(Class<T> clazz){
        ArrayList<T> list = new ArrayList<>();
        for(CustomFormElement element: elements){
            if(clazz.isInstance(element)) list.add(clazz.cast(element));
        }
        return list;
    }

    public Label getLabel(int index){
        return (Label) elements.get(index);
    }

    public Label getLabel(String elementId){
        return get(elementId, Label.class);
    }

    public List<Label> getLabels(){
        return get(Label.class);
    }

    public Input getInput(int index){
        return (Input) elements.get(index);
    }

    public Input getInput(String elementId){
        return get(elementId, Input.class);
    }

    public List<Input> getInputs(){
        return get(Input.class);
    }

    public Toggle getToggle(int index){
        return (Toggle) elements.get(index);
    }

    public Toggle getToggle(String elementId){
        return get(elementId, Toggle.class);
    }

    public List<Toggle> getToggles(){
        return get(Toggle.class);
    }

    public StepSlider getStepSlider(int index){
        return (StepSlider) elements.get(index);
    }

    public StepSlider getStepSlider(String elementId){
        return get(elementId, StepSlider.class);
    }

    public List<StepSlider> getStepSliders(){
        return get(StepSlider.class);
    }

    public Dropdown getDropdown(int index){
        return (Dropdown) elements.get(index);
    }

    public Dropdown getDropdown(String elementId){
        return get(elementId, Dropdown.class);
    }

    public List<Dropdown> getDropdowns(){
        return get(Dropdown.class);
    }

    @Override
    public void handle(Player player) {
        if(handler == null) return;
        handler.handle(player, this);
    }

    public boolean isValidated(){
        return form.isValidated();
    }

    public ArrayList<String> getValidatorErrors(){
        ArrayList<String> errors = new ArrayList<>();
        for(CustomFormElement el: elements){
            if(!(el instanceof ValidationField)) continue;
            ValidationField validationField = (ValidationField) el;
            for(Validator validator: validationField.getValidators()){
                if(validator.isValidated()) continue;

                errors.add(validator.getName());
            }
        }
        return errors;
    }

}
