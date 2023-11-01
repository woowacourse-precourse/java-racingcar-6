package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ResultByRace {
    private static final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?";
    public static final String NUMBER_ERROR = "시도 횟수는 숫자여야 합니다.";
    public static final String POSITIVE_ERROR = "시도 횟수는 양수여야 합니다.";
    public static final String EXECUTION_RESULTS = "실행 결과";
    private int finalRound = 0;
    private int currentRound = 0;

    public void askPlayTime() {
        System.out.println(INPUT_TRY_TIMES);
        try {
            finalRound = inputPlayTimes();
            if (finalRound <= 0) {
                throw new IllegalArgumentException(POSITIVE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    private int inputPlayTimes() {
        return Integer.parseInt(Console.readLine());
    }

    public void showEachResult(Cars cars) {
        System.out.println(EXECUTION_RESULTS);
        while (currentRound <= finalRound) {
            cars.move();
            System.out.println();
            currentRound++;
        }
    }

    public void showWinner(Cars cars) {
        cars.determineWinners();
    }

    public int getFinalRound() {
        return finalRound;
    }
}
