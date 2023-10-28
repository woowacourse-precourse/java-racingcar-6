package racingcar.view;

import java.util.List;
import racingcar.dto.output.RoundResultDTO;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printRoundResult(List<RoundResultDTO> roundResultDTOS) {
        if (isFirstTime) {
            System.out.println("\n실행 결과");
            isFirstTime = false;
        }

        for (RoundResultDTO roundResultDTO : roundResultDTOS) {
            System.out.println(roundResultDTO);
        }
        System.out.println();
    }
}
