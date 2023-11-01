package racingcar;

public class Car {
    private static final int MOVING_FORWARD = 4;
    int randomNumber;
    int forwardCount;
    String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public int moveForward(int randomNum) {
        if (randomNum >= MOVING_FORWARD)
            forwardCount++;
        return forwardCount;
    }
}
