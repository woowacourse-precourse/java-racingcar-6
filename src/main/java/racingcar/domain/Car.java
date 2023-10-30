package racingcar.domain;

public class Car {
    private String name;
    private Long id;
    private int position = 0;

    public Car(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public void moveForward() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }


}
