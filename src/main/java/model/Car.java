package model;

public class Car {
    String name;
    String nowPlace = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move_forward(String onePlace) {
        this.nowPlace = this.nowPlace + onePlace;
    }

    public String getNowPlace() {
        return nowPlace;
    }

}
