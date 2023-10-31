package racingcar.dto;

import java.util.List;

public class GameResultDto {

    private List<CarStatusDto> winners;

    private GameResultDto(List<CarStatusDto> winners) {
        this.winners = winners;
    }

    public static GameResultDto createFrom(List<CarStatusDto> winners) {
        return new GameResultDto(winners);
    }

    public List<CarStatusDto> getWinners() {
        return winners;
    }

}
