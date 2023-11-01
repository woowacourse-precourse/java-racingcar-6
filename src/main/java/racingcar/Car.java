package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int movingCount;

    public Car(String carName, int movingCount) {
        this.carName = carName;
        this.movingCount = movingCount;
        checkCarNameLength();
    }

    public void checkCarNameLength() {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 초과인 잘못된 입력입니다.");
        }
    }

    public boolean isOverFour() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void raiseMovingCount() {
        if (isOverFour()) {
            movingCount++;
        }
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String getCarName() {
        return carName;
    }
}
