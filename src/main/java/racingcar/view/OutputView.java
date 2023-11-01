package racingcar.view;

import static racingcar.util.Messages.*;

import java.util.List;
import racingcar.domain.dto.CarDTO;

public class OutputView {
    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printInputRacingCount() {
        System.out.println(INPUT_RACING_COUNT);
    }

    public static void printStartRacing() {
        System.out.println(RACING_RESULT);
    }

    public static void carResult(List<CarDTO> carDTOs) {
        for (CarDTO carDTO : carDTOs) {
            System.out.print(carDTO.getName() + COLON);
            printMoveCount(carDTO.getMoveCount());
        }
        System.out.println();
    }

    private static void printMoveCount(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(HYPHEN);
        }
        System.out.println();
    }

    public static void printFinalWinner(String winner) {
        System.out.println(FINAL_WINNER + COLON + winner);
    }
}
