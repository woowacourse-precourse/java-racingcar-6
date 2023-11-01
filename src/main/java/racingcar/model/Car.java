package racingcar.model;

public class Car {
    private static final int startBoost = 0;
    private final String carName;
    private int carScore;

    public Car(String carName) {
        this.carName = carName;
        this.carScore = startBoost;
    }

    public void moveForward(int carRandomNumber) {
        if (carRandomNumber >= 4) {
            this.carScore++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarScore() {
        return carScore;
    }


}
