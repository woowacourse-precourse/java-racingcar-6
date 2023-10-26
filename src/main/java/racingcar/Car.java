package racingcar;

public class Car {

    private String name;
    private int count;

    public void move() {
        count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
