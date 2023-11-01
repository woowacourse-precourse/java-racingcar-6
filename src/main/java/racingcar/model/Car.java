package racingcar.model;

public class Car {

    private final String name;

    private Long position;

    public Car(String name) {
        this(name, 0L);
    }

    private Car(String name, Long position) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (position == null) {
            throw new IllegalArgumentException("position must not be null");
        }

        this.name = name;
        this.position = position;
    }

    public void foward() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }
}
