package racingcar.dto;

import java.util.List;

public class GameResultDto {

    private final List<RoundResultDto> roundHistories;
    private final List<CarStatusDto> winners;

    private GameResultDto(List<RoundResultDto> roundHistories, List<CarStatusDto> winners) {
        this.roundHistories = roundHistories;
        this.winners = winners;
    }

    public static GameResultDto of(List<CarStatusDto> winners, List<RoundResultDto> roundHistories) {
        return new GameResultDto(roundHistories, winners);
    }

    public List<CarStatusDto> getWinners() {
        return winners;
    }

    public List<RoundResultDto> getRoundHistories() {
        return roundHistories;
    }


}
