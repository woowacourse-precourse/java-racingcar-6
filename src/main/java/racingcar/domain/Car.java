package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;

    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void moveForward(int engine) {
        if (engine >= MOVE_CONDITION) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5까지 지정 가능합니다.");
        }
    }
    
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}