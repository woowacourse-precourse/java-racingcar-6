package racingcar.domain;

public class Car {
    String carName = "";
    int carPosition = 0;

    public Car() {
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public boolean tryMoveCar() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int randomNum = numberGenerator.createRandomNumber();
        if (randomNum >= 4) {
            this.carPosition += 1;
            return true;
        }
        return false;
    }

}
