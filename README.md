![logo by @tolimag](.github/logo.png)

[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-2.0.0-brightgreen)](https://github.com/ContentForge/FormConstructor/releases/tag/2.0.0)

:warning:  Discontinued :warning: 
======
I stopped writing plugins for Nukkit and I don't see any point in supporting this project. 
Use a good fork that my friend made: https://github.com/MEFRREEX/FormConstructor



Introduction
------------- 

Library is designed to simplify the creation and handling of forms.
It has a few key advantages over other  form libraries:

- Forms are processed using a lambda, which is passed when the form itself is created, and not by catching events.
- For each button we can set a lambda function in SimpleForm.
- In SimpleForm we get a button object as a response, where we can get its text and index.
- In CustomForm we can mark elements with an identifier to conveniently get this element in its handler. We can get element by id and its index.
- Easy async handling.

Examples
-------------

### SimpleForm
```java
SimpleForm form = new SimpleForm("Sample title");

SimpleFormHandler handler = (p, button) -> {
    p.sendMessage("Your selected button is " + button.getName());
    p.sendMessage("Its index - " + button.index);
};

form.setContent("This is a text")
    .addContent("\nThis is addition :3")
    .add(new Button("Test button", handler))
    .add(new Button("Same button but with image", Button.Icon.texture("textures/items/diamond"), handler));

//We can set handler for null result
form.setOnCloseHandler(p -> {
    p.sendMessage("Why you closed this form? :c");
});

form.send(player);
```

### ModalForm
```java
ModalForm form = new ModalForm("Test modal form");

form.setContent("Is OneKN gay?") //local meme in RuNukkitDev
    .setPositiveButton("Yes")
    .setNegativeButton("Sure");

form.setResponse((p, result) -> {
    p.sendMessage(result? "I knew it!" : "Quite right :D");
});

form.send(player);
```

### CustomForm
```java
CustomForm form = new CustomForm("Sample custom form");

List<SelectableElement> elements = Arrays.asList(
    new SelectableElement("Option 1"),
    new SelectableElement("Option 2 but with value", 42),
    new SelectableElement("Option 3")
);

form.add(new Label("This is a test"))
    .add("Easy way to add a label")
    .add("my-text", new Input("A sample input"))
    .add("my-toggle", new Toggle("Toggle?", true))
    .add("my-dd", new Dropdown("Dropdown",  elements))
    .add(new Dropdown("Dropdown with default value", elements, 1))
    .add("my-ss", new StepSlider("Step slider", elements, 2));

form.setHandler((p, response) -> {
    //We can get by id and index
    p.sendMessage(response.getInput("my-text").getValue());
    p.sendMessage(response.getInput(1).getValue()); //It's bad practice. Do not use indexes
    p.sendMessage(response.getToggle("my-toggle").getValue());
    
    SelectableElement el = response.getDropdown("my-dd").getValue();
    p.sendMessage(el.getText());
    if(el.getValue() != null) p.sendMessage(el.getValue(Integer.class));
    
    el = response.getStepSlider("my-ss").getValue();
    p.sendMessage(el.getText());
});

form.send(player);
```

### Async handling
Also you can use method `form.sendAsync(player)` for using async form handling.
