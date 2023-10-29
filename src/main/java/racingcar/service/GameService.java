package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.OptionalInt;

public class GameService {

    public boolean checkMovePossible() {
        int number = createRandomNumber();

        return number >= 4;
    }

    public Integer getWinnerLocation(Integer[] locations) {
        OptionalInt maxLocation = Arrays.stream(locations)
                .mapToInt(Integer::intValue)
                .max();

        if (maxLocation.isPresent()) {
            return maxLocation.getAsInt();
        }

        return 0;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
