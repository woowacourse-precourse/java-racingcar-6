package racingcar.game.domain;

public class Car {
    private final String name;
    private final CarEngine engine;
    private int mileage;

    public Car(String name, CarEngine engine) {
        this.name = name;
        this.engine = engine;
        this.mileage = 0;
    }

    public int getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    public int compareMileage(Car o) {
        return mileage - o.getMileage();
    }

    public void go() {
        if (engine.checkWorking()) {
            this.mileage += 1;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(mileage);
    }
}
