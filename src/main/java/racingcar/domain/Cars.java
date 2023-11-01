package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;
import racingcar.dto.RoundResultDto;

public class Cars {

    private static final String NAME_DELIMITER = ",";
    private static final String NO_CAR_ERROR_MESSAGE = "자동차가 존재하지 않습니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "자동차 이름이 중복됩니다.";

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;


    public Cars(final String names) {
        validate(names);
        this.cars = new ArrayList<>(convertToCars(names));
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void validate(final String names) {
        validateCarsSize(names);
        validateDuplication(names);
    }

    private void validateCarsSize(final String names) {
        if (hasNoCars(names)) {
            throw new IllegalArgumentException(NO_CAR_ERROR_MESSAGE);
        }
    }

    private boolean hasNoCars(final String names) {
        return getSplitNamesByDelimiter(names).size() == 0;
    }

    private void validateDuplication(final String names) {
        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicatedName(final String names) {
        return getSplitNamesByDelimiter(names).size() != getSizeWithoutDuplication(names);
    }

    private int getSizeWithoutDuplication(final String names) {
        return getSplitNamesByDelimiter(names).stream()
                .map(Name::new)
                .collect(Collectors.toSet())
                .size();
    }

    private List<Car> convertToCars(final String names) {
        return getSplitNamesByDelimiter(names).stream()
                .map(Car::new)
                .toList();
    }

    private List<String> getSplitNamesByDelimiter(final String names) {
        return Arrays.stream(names.split(NAME_DELIMITER))
                .toList();
    }

    public void moveEachCar() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    public List<String> findWinnersName() {
        Car winner = findWinner();
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .toList();
    }

    private Car findWinner() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NO_CAR_ERROR_MESSAGE);
                });
    }

    public RoundResultDto toRoundResultDto() {
        return new RoundResultDto(getRoundResults());
    }

    private List<CarDto> getRoundResults() {
        return cars.stream()
                .map(Car::toCarDto)
                .toList();
    }

}
