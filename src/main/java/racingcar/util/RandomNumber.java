package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public record RandomNumber() {
    public static Integer createRandomNumber(Integer min, Integer max) {
        Integer randomNumber = Randoms.pickNumberInRange(min, max);
        return randomNumber;
    }
}
