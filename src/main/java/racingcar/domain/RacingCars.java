package racingcar.domain;

import racingcar.validator.RacingCarValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String COMMA = ",";
    private List<RacingCar> racingCars;

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCars(String racingCars) {
        RacingCarValidator.racingCarNameInputValidator(racingCars);
        List<RacingCar> racingCarList = Arrays.stream(racingCars.split(COMMA))
                .map(car -> new RacingCar(car, 0))
                .collect(Collectors.toList());
        this.racingCars = racingCarList;
    }

    public void moveRacingCar() {
        racingCars.stream().forEach(RacingCar::moveRacingCar);
    }

    public Winner getWinner() {
        return new Winner(racingCars);
    }
}
