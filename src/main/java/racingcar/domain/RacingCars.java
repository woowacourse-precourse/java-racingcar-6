package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Utils;

public class RacingCars {
    private final static List<RacingCar> racingCars = new ArrayList<>();

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public boolean lengthCheck() {
        if (!racingCars.stream().allMatch(e -> Utils.wordLengthCheck(e.toString()))) {
            return false;
        }
        return true;
    }
}
