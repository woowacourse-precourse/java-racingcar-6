package racingcar.domain.car;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position) + "\n";
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public Car race(int randomNumber) {
        goAndStop(randomNumber);
        return this;
    }

    private void goAndStop(int randomNumber) {
        if (randomNumber > 3) {
            this.position++;
        }
    }
}
