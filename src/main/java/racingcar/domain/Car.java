package racingcar.domain;

public class Car {
    String name;
    int movement;

    public Car(String name) {
        this.name = name;
    }

    void race(int randomNum) {
        if (randomNum >= 4) {
            movement++;
        }
    }
}
