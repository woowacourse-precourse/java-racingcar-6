package racingcar.domain.racing;

import java.util.List;

public class RacingPrinter {
    private static final String RACING_ROUND_RESULT_MESSAGE = "실행 결과\n";
    private StringBuilder sb;

    public RacingPrinter() {
        this.sb = new StringBuilder(RACING_ROUND_RESULT_MESSAGE);
    }

    public void updateRacingResult(List<RacingMovement> movements) {
        for(RacingMovement move : movements) {
            sb.append(move.getName()).append(" : ").append("-".repeat(move.getNumber())).append("\n");
        }
        sb.append("\n");
    }

    public String getRacingResult() {
        return sb.toString();
    }
}
