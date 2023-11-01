package racingcar;

import static racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    private static final Integer MINIMUM_NUMBER_OF_CAR_NAMES = 2;

    private List<RacingCar> racingCars;

    public RacingCars(String carNamesBeforeSeparation) {
        String[] carNames = carNamesBeforeSeparation.split(RACING_CAR_NAME_SEPARATOR);
        validateCarNameDuplicate(carNames);
        validateNumberOfCarNames(carNames);
        this.racingCars = Arrays.stream(carNames).map(RacingCar::new).toList();
    }

    private void validateCarNameDuplicate(String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

    private void validateNumberOfCarNames(String[] carNames) {
        if (carNames.length < MINIMUM_NUMBER_OF_CAR_NAMES) {
            throw new IllegalArgumentException(NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS);
        }
    }

    public void race() {
        racingCars.stream().forEach(RacingCar::moveOrStay);
    }

    private Integer findMaxLocation() {
        return racingCars.stream().mapToInt(RacingCar::getLocation).max().getAsInt();
    }

    public List<String> getWinnerNames() {
        Integer maxLocation = findMaxLocation();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .map(RacingCar::getName)
                .toList();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        racingCars.stream().forEach(racingCar -> stringJoiner.add(racingCar.toString()));
        return stringJoiner.toString();
    }
}
