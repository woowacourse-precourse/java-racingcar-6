package racingcar.domain;

public class Car {

    private String name;
    private int progressCount;

    public Car(String name) {
        this.name = name;
        progressCount = 0;
    }

    public void move(int randomNum) {
        if (isMoveForward(randomNum)) {
            moveForward();
        }
    }

    private boolean isMoveForward(int randomNum) {
        return randomNum >= 4;
    }

    private void moveForward() {
        progressCount++;
    }
}
