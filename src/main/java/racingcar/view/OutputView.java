package racingcar.view;

import java.util.List;
import racingcar.model.CarDto;

public class OutputView {
    private static final String ROUND_REG_EX = " : ";
    private static final String POSITION_EXPRESSION = "-";


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
}
