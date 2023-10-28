package racingcar.domain;

import java.util.List;

public class RacingCar extends Car{
    private final Integer CAR_MOVEMENT = 0;

    private Integer carMovement;

    public RacingCar(List<String> carNames) {
        super(carNames);
        this.carMovement = CAR_MOVEMENT;
    }

    public static RacingCar fromInputCarName(String inputCarName) {
        return new RacingCar(List.of(inputCarName.split(",")));
    }

    public boolean isMoveCountLessThanOrEqualTo(Integer userInputMovement) {
        return carMovement <= userInputMovement;
    }

    public void forward() {
        carMovement++;
    }
}
