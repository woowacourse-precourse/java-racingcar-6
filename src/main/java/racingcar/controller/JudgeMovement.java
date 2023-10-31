package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import org.assertj.core.error.ShouldBeFalse;

public class JudgeMovement {
    public static int getRandomNumber(int n, int m) {
        return pickNumberInRange(n, m);
    }

    public static boolean goFlag(int randomNumber, int c) {
        return randomNumber >= c;
    }

}
