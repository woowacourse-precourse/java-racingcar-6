package racingcar.domain;

public class Car {
    private final String name;
    private int progress;

    private Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public void go(int progress) {
        if (progress >= 4) {
            this.progress += progress;
        }
    }
}