package racingcar.domain.car;

public class Car {
    private final String name;
    private final Engine engine;

    private Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public static Car of(String name, Engine engine) {
        return new Car(name, engine);
    }

    public int getAccelerationValue() {
        return engine.pressAccelerator();
    }

    public String getName() {
        return name;
    }

}
