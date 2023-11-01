package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void validateCarName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public void moveOrStop(int determinationNumber) {
        if(determinationNumber >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }
    
    public String getName() {
        return name;
    }
}
