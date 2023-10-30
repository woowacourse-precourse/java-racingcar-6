package racingcarv2.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_TOTAL_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACE_STATUS_START_MESSAGE = "실행 결과";

    public static final String DASH = "-";
    public static final String EACH_ROUND_STATUS_FORMAT = "%s : %s\n";
    public static final String FINAL_WINNER = "최종 우승자";

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputRoundTotal() {
        System.out.println(INPUT_ROUND_TOTAL_MESSAGE);
    }

    public static void printRoundStatus() {
        System.out.println(RACE_STATUS_START_MESSAGE);
        System.out.println();
    }

    public static void printEachRound(List<Car> moveAllCars) {
        moveAllCars.stream()
                .forEach((car) -> System.out.printf(EACH_ROUND_STATUS_FORMAT, car.getName().getNameValue(),
                        displayPositionWithDash(car.getPosition())));
        System.out.println();
    }

    private static String displayPositionWithDash(Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, position.getPositionValue())
                .forEach((num) -> stringBuilder.append(DASH));
        return stringBuilder.toString();
    }

    public static void printWinnerNames(List<Name> winnerNames) {
        List<String> nameList = winnerNames.stream()
                .map(Name::getNameValue)
                .collect(Collectors.toList());
        System.out.printf(EACH_ROUND_STATUS_FORMAT, FINAL_WINNER, String.join(", ", nameList));
    }
}
