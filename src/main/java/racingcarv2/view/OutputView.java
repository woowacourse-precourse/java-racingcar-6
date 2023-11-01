package racingcarv2.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcarv2.controller.RacingCarController;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_TOTAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_STATUS_START_MESSAGE = "실행 결과";

    private static final String DASH = "-";
    private static final String EACH_ROUND_STATUS_FORMAT = "%s : %s\n";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";

    public static void printInputCarNames() {
        printMessage(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputRoundTotal() {
        printMessage(INPUT_ROUND_TOTAL_MESSAGE);
    }

    public static void printRoundStatus() {
        printMessage(RACE_STATUS_START_MESSAGE);
        printNewLine();
    }

    public static void printEachRound(List<Car> moveAllCars) {
        moveAllCars.stream()
                .forEach((car) -> System.out.printf(EACH_ROUND_STATUS_FORMAT, car.getName().getNameValue(),
                        displayPositionWithDash(car.getPosition())));
        printNewLine();
    }

    private static String displayPositionWithDash(Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(RacingCarController.START_INCLUSIVE, position.getPositionValue())
                .forEach((num) -> stringBuilder.append(DASH));
        return stringBuilder.toString();
    }

    public static void printWinnerNames(List<Name> winnerNames) {
        List<String> nameList = winnerNames.stream()
                .map(Name::getNameValue)
                .collect(Collectors.toList());
        System.out.printf(EACH_ROUND_STATUS_FORMAT, FINAL_WINNER, String.join(WINNER_DELIMITER, nameList));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
