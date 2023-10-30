package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static int toInt(String inputPlayCount) {
        try {
            return Integer.parseInt(inputPlayCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
