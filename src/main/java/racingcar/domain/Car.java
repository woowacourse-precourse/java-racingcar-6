package racingcar.domain;

public class Car {
    private static final int RANDOM_VALUE_LIMIT = 4;

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void move(int random) {
        if (random >= RANDOM_VALUE_LIMIT) {
            count++;
        }
    }
}
