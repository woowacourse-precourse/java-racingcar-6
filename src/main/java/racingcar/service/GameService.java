package racingcar.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;

public class GameService {

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]+[0-9]*$";
    private static final String NUMBER_ERROR_MESSAGE = "양수가 아닙니다.";
    private static final String RANGE_ERROR_MESSAGE = "int 범위 숫자가 아닙니다.";

    public Cars createCars(final String names) {
        return new Cars(names);
    }

    public int createTrialCount(final String trialCount) {
        validateTrialCount(trialCount);
        return Integer.parseInt(trialCount);
    }

    private void validateTrialCount(final String trialCount) {
        validatePositiveNumber(trialCount);
        validateRange(trialCount);
    }

    private void validatePositiveNumber(final String trialCount) {
        Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(trialCount);
        if (!matcher.find()) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateRange(final String trialCount) {
        long parseLong = Long.parseLong(trialCount);
        if (parseLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public CarsDto playRound(final Cars cars) {
        cars.move();
        return cars.toCarsDto();
    }

    public List<String> findWinnersName(final Cars cars) {
        return cars.findWinners();
    }

}
