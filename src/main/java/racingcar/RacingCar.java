package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.HYPHEN;
import static racingcar.constant.TextConstant.STARTING_POINT;

public class RacingCar {

    private String carName;
    private String currentLocation;

    private RacingCar(final String carName, final String currentLocation) {
        this.carName = carName;
        this.currentLocation = currentLocation;
    }

    public static RacingCar of(final String carName) {
        return new RacingCar(carName, STARTING_POINT);
    }

    public static List<RacingCar> createRacingCars(final String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = RacingCar.of(carName);
            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        if (randomNumber > MIN_MOVEMENT_CONDITION_NUMBER) {
            currentLocation += HYPHEN;
        }
    }

    public String getCarName() {
        return carName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}
