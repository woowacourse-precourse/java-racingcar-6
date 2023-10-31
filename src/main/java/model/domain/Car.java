package model.domain;

public class Car {

    private final Name name;
    private final Go go;

    public Car(String name) {

        this.name = new Name(name);
        this.go = new Go();

    }

    public Name getName() {
        return name;
    }

    public void add() {
        go.add();
    }

    public int getGoValue() {
        return go.getGo();
    }

    public String getNameValue() {
        return name.getName();
    }
}
