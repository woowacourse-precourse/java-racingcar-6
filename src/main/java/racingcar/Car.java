package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int MAX_NAME_LEN = 5;
    public static final int MIN_RANDOM_NUM = 1;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int MOVE_THRESHOLD = 4;

    public static void validateName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException();
        }
    }

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        if (isMovable(random)) {
            position++;
        }
    }

    private boolean isMovable(int random) {
        return random >= MOVE_THRESHOLD;
    }
}
