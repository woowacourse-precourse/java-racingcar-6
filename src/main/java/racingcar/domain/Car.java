package racingcar.domain;

public class Car {
    private static final int INIT_PROGRESS = 0;

    private String name;
    private int progress;

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car CreateCar(String name) {
        return new Car(name, INIT_PROGRESS);
    }
}
