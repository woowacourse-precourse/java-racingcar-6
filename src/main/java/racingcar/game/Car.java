package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MINIMUM_MOVABLE_NUMBER = 4;

    private final String name;
    private final int position;

    public Car(String name) {
        this(name, 0);
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car moveForward() {
        // 기존 Car 객체의 불변성을 보장하기 위해
        // 새로운 Car 객체를 반환하면서 position을 1 증가시킨다.
        return new Car(name, position + 1);
    }

    public boolean isMovable() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER) >= MINIMUM_MOVABLE_NUMBER;
    }

    @Override
    public String toString() {
        // 자동차의 상태를 문자열로 반환
        return name + " : " + "-".repeat(position);
    }
}