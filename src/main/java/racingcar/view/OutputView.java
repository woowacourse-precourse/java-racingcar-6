package racingcar.view;

import java.util.List;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printRoundResult(List<RoundDTO> roundDTOs) {
        if (isFirstTime) {
            System.out.println("\n실행 결과");
            isFirstTime = false;
        }

        for (RoundDTO roundDTO : roundDTOs) {
            System.out.println(roundDTO);
        }
        System.out.println();
    }

    public static void printWinner(WinnerDTO winnerDTO) {
        System.out.println(winnerDTO);
    }
}
