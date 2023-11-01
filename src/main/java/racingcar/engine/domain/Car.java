package racingcar.engine.domain;

public class Car {

    private String name;
    private int progress = 0;

    public Car(String name) {
        this.name = name;
    }

    public void drive(int threshold, int randomNumber) {
        if (randomNumber >= threshold) {
            this.progress++;
        }
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
