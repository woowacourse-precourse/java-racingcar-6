package racingcar.domain.caractions;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public int getNumber() {
        int Number;
        Number = generateRandomNumber();
        if (isValidNumber(Number)) {
            return 1;
        }
        return 0;
    }


    private int generateRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    private Boolean isValidNumber(int Number) {
        return Number >= 4;
    }
}