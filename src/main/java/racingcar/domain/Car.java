package racingcar.domain;

public class Car {
    String carName;
    int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public void forward() {
        position++;
    }

    public void stop() {
    }
}