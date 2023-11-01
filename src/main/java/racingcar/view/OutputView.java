package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ROUND = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_TEXT = "실행 결과";
    private static final String MOVE = "-";
    private static final String FINAL_WINNERS = "최종 우승자";
    private static final String DELIMITER = " : ";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final int INIT_POSITION = 0;

    private OutputView() {
        throw new IllegalArgumentException();
    }

    public static void printNewLine() {
        System.out.print(NEW_LINE);
    }

    public static void printAskCarNames() {
        System.out.println(ASK_CAR_NAMES);
    }

    public static void printAskRound() {
        System.out.println(ASK_ROUND);
    }

    public static void printExecutionResultText() {
        printNewLine();
        System.out.println(EXECUTION_RESULT_TEXT);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + DELIMITER + MOVE.repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<Car> cars) {
        System.out.print(FINAL_WINNERS + DELIMITER + String.join(WINNERS_DELIMITER, getWinnersName(cars)));
    }

    private static List<String> getWinnersName(List<Car> cars) {
        int winnersPosition = getWinnersPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == winnersPosition)
                .map(Car::getName)
                .toList();
    }

    private static int getWinnersPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(INIT_POSITION);
    }
}
