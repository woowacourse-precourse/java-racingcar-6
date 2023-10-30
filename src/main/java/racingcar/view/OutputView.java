package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String COMMA = ", ";
    private static final String WINNER_IS = "최종 우승자 : ";

    public static void startDisplayRoundResults() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void displayRoundResult(Cars cars) {
        System.out.println(cars.generateRoundResultString());
    }

    public static void displayWinners(List<Car> winners) {
        String displayFormat = String.join(COMMA, winners.stream().map(
                        car -> car.getNameFormat())
                .collect(Collectors.toList()));
        System.out.println(WINNER_IS + displayFormat);
    }
}
