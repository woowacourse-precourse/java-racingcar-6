package racingcar.view;

import java.util.List;
import racingcar.dto.OutputDTO;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printRacingStatus(List<OutputDTO> outputDTOs) {
        if (isFirstTime) {
            System.out.println("\n실행 결과");
            isFirstTime = false;
        }

        for (OutputDTO outputDTO : outputDTOs) {
            System.out.println(outputDTO);
        }
        System.out.println();
    }
}
