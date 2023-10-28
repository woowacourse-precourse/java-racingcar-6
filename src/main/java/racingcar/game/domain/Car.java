package racingcar.game.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private final CarEngine engine;
    private int position;

    public Car(String name, CarEngine engine) {
        this.name = name;
        this.engine = engine;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void go() {
        if (engine.checkWorking()) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    @Override
    public int compareTo(Car o) {
        return position - o.getPosition();
    }
}
