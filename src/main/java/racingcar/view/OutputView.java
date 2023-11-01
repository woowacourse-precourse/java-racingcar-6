package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_COMMAND = "\n실행 결과";
    private static final String COLON_SPACE = " : ";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COMMA = ", ";
    private static final String HYPHEN = "-";

    public static void printResultCommand() {
        System.out.println(RESULT_COMMAND);
    }

    public static void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + COLON_SPACE + generateHyphen(car.getDistance()));
        }
        System.out.println();
    }

    private static String generateHyphen(int count) {
        return HYPHEN.repeat(count);
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(FINAL_WINNER + getCarListName(winners));
    }

    private static String getCarListName(List<Car> carList) {
        return carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));
    }
}
