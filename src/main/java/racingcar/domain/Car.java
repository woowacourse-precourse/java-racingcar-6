package racingcar.domain;

import static racingcar.domain.Moving.isMovable;

public class Car implements Comparable<Car>{
    private static final int NAME_MAX_LENGTH = 5;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) throw new IllegalArgumentException("[ERROR] 이름은 5글자를 넘을 수 없습니다.");
    }

    public void progress() {
        if (isMovable()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - position;
    }

}
