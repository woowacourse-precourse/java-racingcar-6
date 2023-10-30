package model;

public class Car {
    private String name;
    private int distance = 0;

    Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if(randomNumber>=4) {
            this.distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }


}
