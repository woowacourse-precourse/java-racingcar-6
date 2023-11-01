package racingcar.view;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;

/**
 * 게임 결과를 출력하는 뷰 클래스
 */
public class OutputView {

    // 모든 라운드의 결과를 출력
    public static void printAllRoundResults(List<AllRoundDTO> allRoundResults) {
        System.out.print(OutputFormatter.formatAllRoundResults(allRoundResults));
    }

    // 우승자를 출력
    public static void printWinner(WinnerDTO winnerDTO) {
        System.out.println(OutputFormatter.formatWinner(winnerDTO));
    }
}
