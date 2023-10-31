package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private String moving;

    public Car(String carName) {
        if (isNameLengthLessThanOrEqualFive(carName)) {
            this.carName = carName;
            this.moving = "";
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getMovingLength() {
        return moving.length();
    }

    public String goOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moving += "-";
        }
        return toString();
    }

    public boolean isNameLengthLessThanOrEqualFive(String carName) {
        if (carName.length() <= 5) return true;
        throw new IllegalArgumentException("이름은 5자리 이하만 가능합니다.");
    }

    @Override
    public String toString() {
        return carName + " : " + moving;

    }
}
