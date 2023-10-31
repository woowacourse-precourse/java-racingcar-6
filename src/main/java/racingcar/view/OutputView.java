package racingcar.view;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;

// OutputView 클래스
public class OutputView {
    public static void printAllRoundResults(List<AllRoundDTO> allRoundResults) {
        System.out.print(OutputFormatter.formatAllRoundResults(allRoundResults));
    }

    public static void printWinner(WinnerDTO winnerDTO) {
        System.out.println(OutputFormatter.formatWinner(winnerDTO));
    }
}
