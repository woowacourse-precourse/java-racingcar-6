package racingcar.model;

public class Car {
    String name;
    int progress;

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public void go() {
        progress += 1;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

}
