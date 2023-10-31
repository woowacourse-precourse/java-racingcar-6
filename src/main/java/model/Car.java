package model;

public class Car {

    private String name;
    private int go;

    public Car(String name) {

        this.name = name;
        this.go = 0;

    }

    public String getName() {
        return name;
    }

    public int getGo() {
        return go;
    }

    public void add() {
        this.go++;
    }
}
