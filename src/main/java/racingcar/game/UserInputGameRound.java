package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGameRound {
    private static String inputGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
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

        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("0부터 9까지의 숫자를 입력해주세요.");
        }
    }

    private static void checkIsZero(int num){
        if(num == 0){
            throw new IllegalArgumentException("시도 횟수 0");
        }
    }
}