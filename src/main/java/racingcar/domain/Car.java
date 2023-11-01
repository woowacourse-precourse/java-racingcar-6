package racingcar.domain;

public class Car {
    private static final Integer NAME_MAX_LENGTH = 5;
    private final String name;
    private Integer moveCount = 0;

    Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Car name max size is " + NAME_MAX_LENGTH + ". current car name : " + name);
        }
    }

    public String getName() {
        return name;
    }

    public void move() {
        moveCount++;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
