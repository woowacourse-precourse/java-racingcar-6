package racingcar.domain;

public class Car {
    int steps;
    String carName;

    public Car(String carName) {
        this.steps = 0;
        this.carName = carName;
    }

    public int getSteps() {
        return steps;
    }

    public String getCarName() {
        return carName;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
