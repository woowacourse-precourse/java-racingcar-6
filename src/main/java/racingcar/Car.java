package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOrNot(int randomNumber) {
        if (randomNumber >= Constant.RANDOM_NUMBER_THRESHOLD) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position++;
    }
}
