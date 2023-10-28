package racingcar.dto;

import java.util.List;

public class FinalResultDto {
    private final List<String> winners;

    public FinalResultDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
