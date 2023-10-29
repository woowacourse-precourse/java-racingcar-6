package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int CRITICAL_OF_MOVING = 4;
    String name;

    private Car(String carName) {
        name = carName;
    }

    public static Car of(String carName) {
        if(carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH_OF_NAME + "글자 이하로 입력해주세요. (" + carName + " : " + carName.length() + "글자)");
        }
        return new Car(carName);
    }

    public int moveRandomDistance() {
        int distance = Randoms.pickNumberInRange(0, 9);

        if (distance < CRITICAL_OF_MOVING) {
            return 0;
        }

        return distance - CRITICAL_OF_MOVING;
    }
}
