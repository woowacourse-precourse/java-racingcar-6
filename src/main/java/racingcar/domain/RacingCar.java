package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private static final String STATUS_FORMAT = " : ";
    private static final String PROGRESS = "-";
    private static final String SPLIT_STANDARD = ",";
    private static final Integer INITIAL_MOVEMENT = 0;

    private String carName;
    private Integer carMovement;

    public RacingCar(String carName) {
        this.carName = carName;
        this.carMovement = INITIAL_MOVEMENT;
    }

    public String printCarName() {
        return carName;
    }

    public static List<RacingCar> createRacingCars(String inputCarName) {
        return Arrays.stream(inputCarName.split(SPLIT_STANDARD))
                .map(RacingCar::new)
                .collect(Collectors.toList());
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
