package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.OptionalInt;

public class GameService {

    public boolean checkMovePossible() {
        int number = createRandomNumber();

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

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
