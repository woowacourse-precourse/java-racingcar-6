package racingcar.domain;

public class Car {
    private final int id;
    private final String name;
    private final int position;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(int id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
