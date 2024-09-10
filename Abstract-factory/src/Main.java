public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new FactoryA();
        UIFactory factoryB = new FactoryB();

        Button buttonA = factoryA.createButton("Button A");
        TextField textFieldA = factoryA.createTextField("Textfield A");
        Checkbox checkboxA = factoryA.createCheckbox("Checkbox A");

        Button buttonB = factoryB.createButton("Button B");
        TextField textFieldB = factoryB.createTextField("Textfield B");
        Checkbox checkboxB = factoryB.createCheckbox("Checkbox B");

        buttonA.display();
        buttonB.display();

        textFieldA.display();
        textFieldB.display();

        checkboxA.display();
        checkboxB.display();

        buttonA.setText("New text");
        buttonA.display();

    }
}