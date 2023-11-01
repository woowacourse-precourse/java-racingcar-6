package racingcar.model;

public class Car {
    private String name;
    private int count;

    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public void addCount() {
        this.count++;
    }
}
