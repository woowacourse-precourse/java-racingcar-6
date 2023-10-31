package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class Trials {

    private static final int MIN_BOUND = 1;
    public static int getTrials() {
        String trials = Console.readLine();
        trialIsNum(trials);
        trialAboveZero(Integer.parseInt(trials));
        return Integer.parseInt(trials);
    }
    // 0회 미만, 입력받은 값이 수가 아닌 경우
    private static void trialIsNum (String trials) {
        try {
            Integer.parseInt(trials);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private static void trialAboveZero(int trials) {
        if (trials < MIN_BOUND) {
            throw new IllegalArgumentException();
        }
    }

}
