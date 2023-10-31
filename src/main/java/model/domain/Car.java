package model.domain;

public class Car {

    private Name name;
    private Go go;

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
