package racingcar.domain.dto;

import java.util.List;

public class WinnersDto {
    private final List<String> winners;

    public WinnersDto(final List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        return this.winners;
    }
}
