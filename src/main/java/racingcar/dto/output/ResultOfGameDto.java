package racingcar.dto.output;

import java.util.List;

public record ResultOfGameDto(List<String> winnerName) {

    public static ResultOfGameDto createWinnersOfGame(List<String> winnerNames) {
        return new ResultOfGameDto(winnerNames);
    }
}
