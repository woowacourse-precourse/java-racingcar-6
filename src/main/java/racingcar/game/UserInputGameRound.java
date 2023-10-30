package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant;

public class UserInputGameRound {
    public static int getGameRound() {
        String inputRound = inputGameRound();
        return processInput(inputRound);
    }

    private static String inputGameRound() {
        System.out.println(Constant.COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    private static int processInput(String round) {
        int gameRound = checkIsNumber(round);
        checkIsZero(gameRound);

        return gameRound;
    }

    private static int checkIsNumber(String gameRound) {
        for (char digit : gameRound.toCharArray()) {
            validateDigit(digit);
        }

        return Integer.parseInt(gameRound);
    }

    private static void validateDigit(char digit) {
        int num = digit - '0';

        if (num < Constant.MIN_VALUE || num > Constant.MAX_VALUE) {
            throw new IllegalArgumentException("0부터 9까지의 숫자를 입력해주세요.");
        }
    }

    private static void checkIsZero(int num){
        if(num == Constant.MIN_VALUE){
            throw new IllegalArgumentException("시도 횟수 0");
        }
    }
}