package racingcar.model;

import static racingcar.constant.ErrorMessage.CAR_NAME_BLANK_OR_NULL;
import static racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    private static final Integer MINIMUM_NUMBER_OF_CAR_NAMES = 2;

    private final List<RacingCar> racingCars;

    public RacingCars(final String carNamesBeforeSeparation) {
        validateCarNameIsBlankOrNull(carNamesBeforeSeparation);
        final String[] carNames = carNamesBeforeSeparation.split(RACING_CAR_NAME_SEPARATOR);
        validateCarNameDuplicate(carNames);
        validateNumberOfCarNames(carNames);
        this.racingCars = Arrays.stream(carNames).map(RacingCar::new).toList();
    }

    private void validateCarNameIsBlankOrNull(String carNamesBeforeSeparation) {
        if (carNamesBeforeSeparation == null || carNamesBeforeSeparation.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_OR_NULL);
        }
    }

    private void validateCarNameDuplicate(final String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

    private void validateNumberOfCarNames(final String[] carNames) {
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
        final Integer maxLocation = findMaxLocation();
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
