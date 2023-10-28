package domain;

public class Car {
    private final String car_name;
    private int location = 0;

    public Car(String car_name) {
        this.car_name = car_name;
    }

    public void moveForward(int move) {
        location += move;
    }

    public String getCar_name() {
        return car_name;
    }

    public int getLocation() {
        return location;
    }
}
