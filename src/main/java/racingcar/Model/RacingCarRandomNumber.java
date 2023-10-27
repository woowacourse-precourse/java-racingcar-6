package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRandomNumber {
    private static final String RandomNumberRange = "무작위 값이 범위를 벗어났습니다.";
    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private static List<Integer> racingCarRandomNumber;

    public static List<Integer> RacingCarRandomNumbers(int tryCount) {
        racingCarRandomNumber = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            validateRandomNumberRange(randomNumber);
            racingCarRandomNumber.add(randomNumber);
        }
        return racingCarRandomNumber;
    }

    public static void validateRandomNumberRange(int randomNumber) {
        throw new IllegalArgumentException(RandomNumberRange);
    }

}
