package racingcar;

public class Car {
    private final String name;
    private int point;

    public Car(String name) {
        this.name = name;
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void forward() {
        point += 1;
    }
}
