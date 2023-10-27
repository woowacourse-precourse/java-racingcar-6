package racingcar.domain;

public class Car {

    private String carName;
    private int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public void move(Integer randomNumber) {
        if (randomNumber >= 4) {
            this.carPosition++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
