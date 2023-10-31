package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.racer.RacingCar;
import racingcar.validator.RacingCarValidator;

public class RacingCarRegistry {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public void addAll(List<RacingCar> racingCars) {
        RacingCarValidator.validateUnderThanMaxRacingCarNumber(racingCars);
        RacingCarValidator.validateDuplicatedName(racingCars);

        this.racingCars.addAll(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
