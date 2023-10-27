package racingcar.domain;

public class Car {

    private static final int NAME_MAX_SIZE = 5;

    private int location = 0;
    private String name;

    public Car(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void move() {
        location++;
    }

    public void validateNameSize(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_SIZE)
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능하다.");
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
