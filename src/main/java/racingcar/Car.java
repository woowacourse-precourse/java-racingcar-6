package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String LOCATION = "-";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_RANDOM = 9;
    private static final int MIN_RANDOM = 0;
    private static final int SATISFY_FOR_MOVE = 4;
    private String name;
    private StringBuilder location;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        location = new StringBuilder();
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 " + MAX_NAME_LENGTH + "보다 깁니다.");
        }
    }

    public void moveIfSatisfy() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
        if (randomNumber >= SATISFY_FOR_MOVE) {
            location.append(LOCATION);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + location;
    }
}
