package racingcar.dto;

import java.util.List;

public class GameResultDto {
    private List<String> winners;

    public GameResultDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        return winners;
    }
}
