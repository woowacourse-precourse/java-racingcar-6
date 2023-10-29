package racingcar.controller.dto;

import java.util.List;

public class WinnerDto {

    List<String> winners;

    public WinnerDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
