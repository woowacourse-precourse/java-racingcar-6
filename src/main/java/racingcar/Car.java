package racingcar;

public class Car {

    String carName;
    int movement = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    void move(int num) {
        movement += isMovable();
        printCurrentState();
    }

    int isMovable() {

    }

    void printCurrentState() {

    }
}
