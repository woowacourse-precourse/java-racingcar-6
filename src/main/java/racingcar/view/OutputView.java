package racingcar.view;

import racingcar.domain.dto.CarDTO;
import java.util.List;
import static racingcar.constant.PrintMessageConstant.*;

public class OutputView {
    public static void inputNameMessage() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void inputCountMessage() {
        System.out.println(INPUT_REPEAT_COUNT);
    }

    public static void executionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    public static void carResult(List<CarDTO> carDTOs) {
        for(CarDTO carDTO :carDTOs) {
            System.out.print(carDTO.getCarName() + COLON);
            printPosition(carDTO.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for(int i = 0; i < position; i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }

    public static void winner(String result) {
        System.out.println(WINNER + result);
    }
}
