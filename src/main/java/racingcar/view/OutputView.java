package racingcar.view;

import java.util.List;
import racingcar.model.dto.CarDto;

public class OutputView {
    private static final String ROUND_REG_EX = " : ";
    private static final String POSITION_EXPRESSION = "-";
    private static final String WINNER_EXPRESSION = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.name() + ROUND_REG_EX + POSITION_EXPRESSION.repeat(car.position()));
        }
        System.out.println();
    }

    public static void printResult(List<String> winners) {
        System.out.print(WINNER_EXPRESSION + String.join(WINNER_DELIMITER, winners));
    }
}
