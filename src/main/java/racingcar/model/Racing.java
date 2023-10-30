package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.count.NoCountInputException;
import racingcar.exception.count.NonNumericStringException;
import racingcar.model.dto.CarDto;
import racingcar.model.number.NumberGenerator;

public class Racing {
    private static final Pattern NUMBER = Pattern.compile("^\\d+$");
    private final Cars cars;
    private final Round round;

    public Racing(Cars cars, String count) {
        this.cars = cars;
        this.round = createRound(count);
    }

    private Round createRound(String count) {
        int intCount = parseIntFromString(count);
        return new Round(intCount);
    }

    public void playRound(NumberGenerator generator) {
        cars.move(generator);
        round.nextRound();
    }

    public List<CarDto> getStatus() {
        return cars.getStatus();
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (CarDto car : cars.getStatus()) {
            findWinners(car, winners);
        }
        return Collections.unmodifiableList(winners);
    }

    private void findWinners(CarDto car, List<String> winners) {
        if (car.position() == cars.getMaxPositions()) {
            winners.add(car.name());
        }
    }

    public boolean isNotFinished() {
        return round.isNotZero();
    }

    private int parseIntFromString(String count) {
        checkEmptyCount(count);
        checkIsNumber(count);
        return Integer.parseInt(count);
    }

    private void checkIsNumber(String count) {
        Matcher matcher = NUMBER.matcher(count);
        if (!matcher.matches()) {
            throw new NonNumericStringException();
        }
    }

    private void checkEmptyCount(String count) {
        if (count.isEmpty()) {
            throw new NoCountInputException();
        }
    }
}
