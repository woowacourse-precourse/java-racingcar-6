package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    final int LENGTH_CAR_NAME = 5;
    final int START_RANDOM_RANGE = 0;
    final int END_RANDOM_RANGE = 9;
    final int TRIGGER_MINIMUM_FORWARD = 4;
    final String MARK_FOR_FORWARD = "-";
    private int forwardCount;
    private String presentCondition;


    public Car(String carName) {
        validateNameLength(carName);
        validateNameSpace(carName);

        this.carName = carName;
        this.forwardCount = 0;
        this.presentCondition = "";
    }

    public String getCarName() {
        return carName;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_RANGE, END_RANDOM_RANGE);
    }

    public void runCar() {
        if (getRandomNumber() >= TRIGGER_MINIMUM_FORWARD) {
            forwardCount++;
            presentCondition += MARK_FOR_FORWARD;
        }

        System.out.println(getPresentCondition());
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getPresentCondition() {
        return getCarName() + " : " + presentCondition;
    }

    final void validateNameLength(String carName) {
        if (!(carName.length() <= LENGTH_CAR_NAME)) {
            throw new IllegalArgumentException(String.format("%d자 이하의 이름만 입력가능", LENGTH_CAR_NAME));
        }
    }

    final void validateNameSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다.");
        }
    }
}
