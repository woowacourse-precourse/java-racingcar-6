package model.domain;

public class Car {

    private Name name;
    private int go;

    public Car(String name) {

        this.name = new Name(name);
        this.go = 0;

    }

    public Name getName(){
        return name;
    }

    public int getGo() {
        return go;
    }

    public void add() {
        this.go++;
    }
}
