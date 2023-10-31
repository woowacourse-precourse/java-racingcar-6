package racingcar.application;

import static racingcar.global.constants.NumberType.*;
import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.exception.RaceException;

public class RaceService {
    public Cars generateCars(String rawNames) {
        return Cars.of(parseStringToList(rawNames));
    }

    public Integer generateCount(String countInput) {
        Integer count = parseStringToInteger(countInput);
        validateRange(count);
        return count;
    }

    public void playRace(Cars cars) {
        cars.tryMoveCars();
    }

    public List<String> getWinners(Cars cars) {
        return cars.findMostMovedCarName();
    }

    private Integer parseStringToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw RaceException.of(ErrorMessage.INVALID_COUNT_FORMAT);
        }
    }

    private List<String> parseStringToList(String names) {
        return Arrays.stream(splitNames(names))
                .map(String::new)
                .toList();
    }

    private String[] splitNames(String names) {
        return names.split(DELIMITER.getSymbol());
    }

    private void validateRange(Integer count) {
        if (isLessThanMinCount(count)) {
            throw RaceException.of(ErrorMessage.INVALID_COUNT_RANGE);
        }
    }

    private boolean isLessThanMinCount(Integer count) {
        return count < MIN_RACE_COUNT.getValue();
    }
}
