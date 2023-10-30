package racingcar.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDto {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private final List<String> winners;

    public WinnerDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }

    public String getWinnerNames() {
        return winners.stream()
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }
}
