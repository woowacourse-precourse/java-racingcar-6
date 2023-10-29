package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    private static final String STATUS_FORMAT = " : ";
    private static final String PROGRESS = "-";
    private static final Integer CAR_MOVEMENT = 0;

    private String carName;
    private Integer carMovement;

    public RacingCar(String carName) {
        this.carName = carName;
        this.carMovement = CAR_MOVEMENT;
    }

    public String printCarName() {
        return carName;
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

    public String carStatus() {
        return carName + STATUS_FORMAT + PROGRESS.repeat(carMovement);
    }

    public boolean hasHigherMovement(RacingCar otherRacingCar) {
        return this.carMovement > otherRacingCar.carMovement;
    }

    public boolean hasEqualMovement(RacingCar otherRacingCar) {
        return this.carMovement.equals(otherRacingCar.carMovement);
    }
}
