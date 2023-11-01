package racingcar.dto;

public class RacingGameResult {
    private final RacingGameStatus racingGameStatus;
    private final WinnerNames winnerNames;

    public RacingGameResult(RacingGameStatus racingGameStatus, WinnerNames winnerNames) {
        this.racingGameStatus = racingGameStatus;
        this.winnerNames = winnerNames;
    }

    public RacingGameStatus getRacingGameStatus() {
        return racingGameStatus;
    }

    public WinnerNames getWinnerNames() {
        return winnerNames;
    }
}
