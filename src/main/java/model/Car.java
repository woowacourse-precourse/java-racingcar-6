package model;

public abstract class Car {
    int position = 0;
    String name;
    int speed;
    public abstract void drive();

    public Car(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
