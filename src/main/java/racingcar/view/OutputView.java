package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String POSITION_FORMAT = "-";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static final String COLON = " : ";
    private static final String JOIN_MARK = ", ";
    private static final String NEW_LINE = "\n";

    public static void executeResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getCarName() + COLON + printPosition(car.getMove()));
        }
        System.out.println();
    }

    private static String printPosition(int move) {
        return POSITION_FORMAT.repeat(move);
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + EXECUTE_RESULT_MESSAGE);
    }

    public static void printWinner(List<String> winnerCarList) {
        System.out.println(WINNER_MESSAGE + COLON + String.join(JOIN_MARK, winnerCarList));
    }

}
