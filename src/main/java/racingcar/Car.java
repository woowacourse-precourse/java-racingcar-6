package racingcar;

import java.util.List;
import java.util.Optional;
import racingcar.dto.output.RoundResultDTO;
import racingcar.dto.output.WinnerDTO;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public RoundResultDTO toDTO() {
        return new RoundResultDTO(name, moveCount);
    }

    public static WinnerDTO toWinnerDTO(List<String> names) {
        return new WinnerDTO(names);
    }

    public Optional<String> getWinnerName(int winnerScore) {
        if (this.moveCount == winnerScore) {
            return Optional.of(name);
        }
        return Optional.empty();
    }

    public int updateMax(int currentMaxMoveCount) {
        return Math.max(this.moveCount, currentMaxMoveCount);
    }
}
