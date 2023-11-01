package racingcar.view;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

/**
 * 출력 형식을 관리하는 포맷터 클래스
 */
public class OutputFormatter {

    // 모든 라운드의 결과를 문자열로 변환
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

    // 하나의 라운드 결과를 문자열로 변환
    private static String formatRound(RoundDTO roundDTO) {
        return roundDTO.getName() + " : " + "-".repeat(Math.max(0, roundDTO.getDistance()));
    }

    // 우승자 정보를 문자열로 변환
    public static String formatWinner(WinnerDTO winnerDTO) {
        return "\n최종 우승자 : " + String.join(",", winnerDTO.getNames());
    }
}
