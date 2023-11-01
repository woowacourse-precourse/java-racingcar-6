package racingcar.game;

import racingcar.Constant;

public class ValidateGame {
    public static void validator(String gameRound) {
        checkIsNumber(gameRound);
        checkIsZero(gameRound);
        checkIsBlank(gameRound);
    }

    private static void checkIsNumber(String gameRound) {
        for (char digit : gameRound.toCharArray()) {
            validateDigit(digit);
        }
    }

    private static void validateDigit(char digit) {
        int num = digit - '0';

        if (num < Constant.MIN_VALUE || num > Constant.MAX_VALUE) {
            throw new IllegalArgumentException("0부터 9까지의 숫자를 입력해주세요.");
        }
    }

    private static void checkIsZero(String gameRound){
        int num = Integer.parseInt(gameRound);
        if(num <= Constant.MIN_VALUE){
            throw new IllegalArgumentException("시도 횟수 0 이하입니다.");
        }
    }

    private static void checkIsBlank(String gameRound){
        if (gameRound.isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }
}
