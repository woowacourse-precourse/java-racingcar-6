package racingcar.dto;

import java.util.List;

public record WinnerNamesDto(List<String> winnerNames) {
    public static WinnerNamesDto from(List<String> winnerNames) {
        return new WinnerNamesDto(winnerNames);
    }
}