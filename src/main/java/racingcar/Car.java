package racingcar;

public class Car {
    private String carName;
    private int movement;

    public Car(String carName) {
        this.carName = carName;
        movement = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovement() {
        return movement;
    }

    public void move() {
        movement++;
    }
}
