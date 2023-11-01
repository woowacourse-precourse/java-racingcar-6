package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarActionGenerator {
    private int number;
    public static final int FORWARD_NUMBER = 4;

    public boolean getDriveOrHalt() {
        getRandomNumber();

        return number >= FORWARD_NUMBER;
    }

    private void getRandomNumber() {
        number = Randoms.pickNumberInRange(0, 9);
        validateNumber();
    }

    private void validateNumber() {
        if (number < 0) {
            throw new IllegalArgumentException("음수를 사용할 수 없습니다!");
        }
        if (number >= 10) {
            throw new IllegalArgumentException("10 이상의 수를 사용할 수 없습니다!");
        }
    }

    public int getNumber() {
        return number;
    }
}
