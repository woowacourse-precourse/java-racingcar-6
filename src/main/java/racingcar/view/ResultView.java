package racingcar.view;

import racingcar.domain.Cars;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String CALL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_STATUS = "-";
    private static final String NANE_COLON = " : ";

    private ResultView() {
    }

    public static void printShowResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void showRoundResult(Cars cars) {
        cars.stream().forEach(car ->
                System.out.println(car.getName() + NANE_COLON + POSITION_STATUS.repeat(car.getPosition())));

        System.out.println();
    }

    public static void callWinner(String winnerNames) {
        System.out.print(CALL_WINNER_MESSAGE);
        System.out.println(winnerNames);
    }
}
