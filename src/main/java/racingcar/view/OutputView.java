package racingcar.view;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printAllRoundResults(List<AllRoundDTO> allRoundResults) {
        printHeader();

        for (AllRoundDTO allRoundDTO : allRoundResults) {
            printSingleRound(allRoundDTO);
        }
    }

    private static void printHeader() {
        if (isFirstTime) {
            System.out.println("\n실행 결과");
            isFirstTime = false;
        }
    }

    private static void printSingleRound(AllRoundDTO allRoundDTO) {
        for (RoundDTO roundDTO : allRoundDTO.roundDTOs()) {
            System.out.println(roundDTO);
        }
        System.out.println();
    }

    public static void printWinner(WinnerDTO winnerDTO) {
        System.out.println(winnerDTO);
    }
}
