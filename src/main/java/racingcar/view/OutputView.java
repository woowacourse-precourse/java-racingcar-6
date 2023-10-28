package racingcar.view;

import racingcar.entity.CarDescription;

import java.util.List;

public class OutputView {

    private static final String PRINT_RESULT_HEADER = "실행 결과";
    private static final String PRINT_RESULT_FORMAT = "%s : %s%n";
    private static final String PRINT_WINNER_FORMAT = "최종 우승자 : %s";
    private static final String POSITION_SHAPE = "-";
    private static final String WINNER_JOIN_SHAPE = ", ";

    public static void printResultHeader() {
        printPadding();
        System.out.println(PRINT_RESULT_HEADER);
    }

    public static void printResult(List<CarDescription> carDescriptions) {
        carDescriptions.forEach(OutputView::printResultEach);
        printPadding();
    }

    private static void printResultEach(CarDescription carDescription) {
        System.out.format(PRINT_RESULT_FORMAT, carDescription.name(), POSITION_SHAPE.repeat(carDescription.position()));
    }

    private static void printPadding() {
        System.out.println();
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.format(PRINT_WINNER_FORMAT, String.join(WINNER_JOIN_SHAPE, winnerNames));
    }
}
