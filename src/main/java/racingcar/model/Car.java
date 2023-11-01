package racingcar.model;

public class Car {
    private static final int startBoost = 0;
    private String carName;
    private int carBoost;

    public Car(String carName) {
        this.carName = carName;
        this.carBoost = startBoost;
    }

    public void moveForward(int carBoost) {
        if (carBoost >= 4) {
            this.carBoost++;
        }
        return;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarBoost() {
        return carBoost;
    }


}
