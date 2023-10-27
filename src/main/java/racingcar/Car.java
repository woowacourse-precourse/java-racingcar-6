package racingcar;

public class Car {
    private String name;
    private StringBuilder progress;

    public Car(String name) {
        this.name = name;
        progress = new StringBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getProgress() {
        return this.progress.toString();
    }

}
