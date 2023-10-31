package racingcar.service;

import java.util.Arrays;
import java.util.OptionalInt;

public class GameService {
    public boolean checkMovePossible(Integer number) {
        return number >= 4;
    }

    public Integer getWinnerPosition(Integer[] positions) {
        OptionalInt winnerPosition = Arrays.stream(positions)
                .mapToInt(Integer::intValue)
                .max();

        if (winnerPosition.isPresent()) {
            return winnerPosition.getAsInt();
        }

        return 0;
    }
}
