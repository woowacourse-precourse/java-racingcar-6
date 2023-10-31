package racingcar.view;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class OutputFormatter {
    public static String formatAllRoundResults(List<AllRoundDTO> allRoundResults) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과");

        for (AllRoundDTO allRoundDTO : allRoundResults) {
            for (RoundDTO roundDTO : allRoundDTO.roundDTOs()) {
                sb.append("\n").append(formatRound(roundDTO));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String formatRound(RoundDTO roundDTO) {
        return roundDTO.getName() + " : " + "-".repeat(Math.max(0, roundDTO.getDistance()));
    }

    public static String formatWinner(WinnerDTO winnerDTO) {
        return "\n최종 우승자 : " + String.join(",", winnerDTO.getNames());
    }
}
