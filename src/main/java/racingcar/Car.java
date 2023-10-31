package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int step = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void increaseStep() {
        step++;
    }

    @Override
    public int compareTo(Car c) {
        return c.getStep() - this.getStep();
    }
}
