package racingcar.domain;

public class Car {

    public static final int INIT_POSITION = 0;
    private final CarName name;
    private final int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = INIT_POSITION;
    }
}
