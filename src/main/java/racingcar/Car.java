package racingcar;

public class Car {
    int randomNumber;
    int forwardCount;
    String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward(int randomNum) {
        if (randomNum >= 4)
            forwardCount++;
    }
}
