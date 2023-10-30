package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.GameStatus;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(GameStatus.READY);
        String inputString = Console.readLine();
        if (!isValidMoveCount(inputString)) {
            racingGame.setStatus(GameStatus.INVALID_USER_INPUT);
        } else {
            int moveCount = Integer.parseInt(inputString);
            racingGame.start(moveCount);
        }
    }

    /**
     * 이동 횟수 입력이 유효한지 검증
     * @param inputString 이동 횟수로 입력받은 값
     * @return 유효하면 true, 그렇지 않으면 false
     */
    private static boolean isValidMoveCount(String inputString) {
        if (!isPositiveNumber(inputString)) {
            throw new IllegalArgumentException(String.format("양수가 아닌 입력값 = %s", inputString));
        }
        return true;
    }

    /**
     * 입력값이 양수인지 검증
     * @param input 입력값
     * @return 양수이면 true, 그렇지 않으면 false
     */
    private static boolean isPositiveNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return num > 0;
    }

}
