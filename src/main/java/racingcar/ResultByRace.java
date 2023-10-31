package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ResultByRace {
    private static final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?";
    public static final String NUMBER_EXCEPTION = "시도 횟수는 숫자여야 한다.";
    public static final String POSITIVE_EXCEPTION = "시도 횟수는 양수이어야 한다.";
    private int round = 0;

    public void askPlayTime() {
        System.out.println(INPUT_TRY_TIMES);
        try {
            int input = inputPlayTimes();
            if (input <= 0) {
                throw new IllegalArgumentException(POSITIVE_EXCEPTION);
            }
            round = input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
    }

    private static int inputPlayTimes() {
        return Integer.parseInt(Console.readLine());
    }
}
