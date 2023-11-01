package racingcar;

import static racingcar.Properties.COMMA;
import static racingcar.Properties.LINE_SEPARATOR;
import static racingcar.Properties.MAX_CAR_NAME_LENGTH;
import static racingcar.Properties.ZERO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private final List<String> roundResults = new ArrayList<>();
    private final List<RacingCar> racingCars = new ArrayList<>();
    private int round = ZERO;

    public void readCarNames(String input) {
        List<String> carNames = extractCarNames(input);

        if (isInvalidCarNames(carNames)) {
            throw new IllegalArgumentException();
        }
        this.racingCars.clear();
        this.racingCars.addAll(carNames.stream().map(RacingCar::new).toList());
    }

    private List<String> extractCarNames(String input) {
        return Arrays.stream(input.split(COMMA)).map(String::trim).toList();
    }

    private boolean isInvalidCarNames(List<String> names) {
        return isDuplicate(names) || names.stream().anyMatch(name ->
                name.isBlank() || isInvalidNameLength(name));
    }

    private boolean isDuplicate(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private boolean isInvalidNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }

    public void readRound(String input) {
        final int number = Integer.parseInt(input);

        if (isInvalidRound(number)) {
            throw new IllegalArgumentException();
        }
        this.round = number;
    }

    private boolean isInvalidRound(int number) {
        return isNegative(number) || isZero(number);
    }

    private boolean isNegative(int number) {
        return number < ZERO;
    }

    private boolean isZero(int number) {
        return number == ZERO;
    }

    public List<String> startRace() {
        if (hasRaceResult()) {
            resetRace();
        }
        int round = this.round;

        while (hasNextRound(round)) {
            this.roundResults.add(playRound());
            round--;
        }
        return this.roundResults;
    }

    private boolean hasRaceResult() {
        return !this.roundResults.isEmpty();
    }

    private void resetRace() {
        this.racingCars.forEach(RacingCar::reset);
        this.roundResults.clear();
    }

    private boolean hasNextRound(int round) {
        return round > ZERO;
    }

    private String playRound() {
        this.racingCars.stream().filter(RacingCar::isMovable).forEach(RacingCar::move);
        return roundResult();
    }

    private String roundResult() {
        return this.racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    public List<String> findWinner() {
        if (this.roundResults.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final int maxPosition = maxPosition();
        return findRacingCarsWithPosition(maxPosition);
    }

    private List<String> findRacingCarsWithPosition(int maxPosition) {
        return this.racingCars.stream()
                .filter(car ->
                        car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .toList();
    }

    private int maxPosition() {
        return this.racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
