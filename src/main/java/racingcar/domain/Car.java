package racingcar.domain;

public class Car {
    public static final Integer NAME_VALIDATION_LENGTH = 5;
    public static final Integer CAR_FORWARD_JUDGMENT_CRITERIA = 4;
    public final String name;
    public Integer position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > NAME_VALIDATION_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void go(int randNumber) {
        if (randNumber >= CAR_FORWARD_JUDGMENT_CRITERIA) {
            this.position ++;
        }
    }
}
