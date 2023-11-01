package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        // 1. 자동차 이름이 5자 이하인지 확인합니다.
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자에서 5자 사이여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move() {
        // 2. 랜덤 값에 따라 자동차의 위치를 변경합니다.
        int randomNumber = calculateRandomNumber();
        if (randomNumber >= 4) {
            position++;
        }
    }

    private int calculateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}