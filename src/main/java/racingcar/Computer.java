package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private final List<String> roundResults = new ArrayList<>();
    private final List<RacingCar> carNames = new ArrayList<>();
    private int round = 0;

    public void readCarNames(String input) {
        List<String> carNames = extractCarNames(input);

        if (isInvalidCarNames(carNames)) {
            throw new IllegalArgumentException();
        }
        this.carNames.clear();
        this.carNames.addAll(carNames.stream().map(RacingCar::new).toList());
    }

    private List<String> extractCarNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    private boolean isInvalidCarNames(List<String> names) {
        return isDuplicate(names) || names.stream().anyMatch(name ->
                name.isBlank() || hasSizeGreaterThanFive(name));
    }

    private boolean isDuplicate(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private boolean hasSizeGreaterThanFive(String name) {
        return name.length() > 5;
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
        return number < 0;
    }

    private boolean isZero(int number) {
        return number == 0;
    }

    public List<String> startRace() {
        if (isZero(this.round)) {
            throw new IllegalArgumentException();
        }
        while (hasNextRound()) {
            this.roundResults.add(playRound());
            endRound();
        }
        return this.roundResults;
    }

    private boolean hasNextRound() {
        return this.round > 0;
    }

    private String playRound() {
        this.carNames.stream().filter(RacingCar::isMovable).forEach(RacingCar::move);
        return roundResult();
    }

    private void endRound() {
        this.round--;
    }

    private String roundResult() {
        return this.carNames.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<String> findWinner() {
        if (isNotZero(this.round) || this.roundResults.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final int maxPosition = this.carNames.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        return this.carNames.stream()
                .filter(car ->
                        car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .toList();
    }

    private boolean isNotZero(int round) {
        return round != 0;
    }
}
