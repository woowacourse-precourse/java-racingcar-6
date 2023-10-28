package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    private final Integer CAR_MOVEMENT = 0;

    private final String carName;

    private Integer carMovement;

    public RacingCar(String carName) {
        this.carName = carName;
        this.carMovement = CAR_MOVEMENT;
    }

    public static List<RacingCar> fromInputCarName(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(","));

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public boolean isMoveCountLessThanOrEqualTo(Integer userInputMovement) {
        return carMovement <= userInputMovement;
    }

    public void forward() {
        carMovement++;
    }
}
