package racingcar.domain;

public class Car implements Comparable<Car>{
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    private void validateCarName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public void moveOrStop(int number) {
        if(number >= MOVE_CONDITION) {
            position++;
        }
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
