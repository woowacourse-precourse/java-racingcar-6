package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ResultByRace {
    private static final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?";
    public static final String NUMBER_EXCEPTION = "시도 횟수는 숫자여야 한다.";
    public static final String POSITIVE_EXCEPTION = "시도 횟수는 양수이어야 한다.";
    private int finalRound = 0;
    private int currentRound = 0;


    public void askPlayTime() {
        System.out.println(INPUT_TRY_TIMES);
        try {
            finalRound = inputPlayTimes();
            if (finalRound <= 0) {
                throw new IllegalArgumentException(POSITIVE_EXCEPTION);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
    }

    private static int inputPlayTimes() {
        return Integer.parseInt(Console.readLine());
    }

    public void showEachResult(Cars cars) {
        while (currentRound <= finalRound) {
            cars.move();
            System.out.println();
            currentRound++;
        }
    }
}
