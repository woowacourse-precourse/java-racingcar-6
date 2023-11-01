package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void play() {
        int size = racingCars.size();
        List<Integer> randomNumbers = new ArrayList<>();

        while (size > 0) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumbers.add(randomNumber);
            size--;
        }

        racingCars.moveCars(randomNumbers);
    }
}
