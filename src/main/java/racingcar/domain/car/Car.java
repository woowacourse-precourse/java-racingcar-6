package racingcar.domain.car;

public class Car {

    private static final int THRESHOLD_FOR_MOVING = 3;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public Car race(int randomNumber) {
        goOrStop(randomNumber);
        return this;
    }

    private void goOrStop(int randomNumber) {
        if (randomNumber > THRESHOLD_FOR_MOVING) {
            this.position++;
        }
    }
    
    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position) + "\n";
    }
}
