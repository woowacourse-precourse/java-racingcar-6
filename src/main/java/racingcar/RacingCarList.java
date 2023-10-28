package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private static final int MIN_LIST_LENGTH = 1;
    private static final int MAX_LIST_LENGTH = 10;

    private final List<RacingCar> racingCars = new ArrayList<>();

    public void addRacingCarsByNames(List<String> names) {
        validateNameList(names);
        names.stream()
                .map(RacingCar::new)
                .forEach(racingCars::add);
    }

    public void moveRacingCarsBasedOnGivenNumbers(List<Integer> randomNumbers) {
        for (int i = 0; i < racingCars.size(); i++) {
            int chosenNumber = randomNumbers.get(i);
            racingCars.get(i).checkAndMoveForward(chosenNumber);
        }
    }

    public List<RacingCarStatus> collectStatus() {
        return racingCars.stream()
                .map(RacingCar::getStatus)
                .toList();
    }

    public List<String> getWinners() {
        List<RacingCarStatus> results = collectStatus();

        int maxPosition = results.stream()
                .mapToInt(RacingCarStatus::getPosition)
                .max()
                .orElse(0);

        return results.stream()
                .filter(result -> result.getPosition() == maxPosition)
                .map(RacingCarStatus::getName)
                .toList();
    }

    private void validateNameList(List<String> names) {
        validateDistinctName(names);
        validateNameCount(names);
    }

    private void validateDistinctName(List<String> names) {
        long distinctNameCount = names.stream()
                .distinct()
                .count();
        if (distinctNameCount < names.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameCount(List<String> names) {
        validateNameCountLargerThanMinimumValue(names);
        validateNameCountSmallerThanMaximumValue(names);
    }

    private void validateNameCountLargerThanMinimumValue(List<String> names) {
        if (names.size() < MIN_LIST_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameCountSmallerThanMaximumValue(List<String> names) {
        if (names.size() > MAX_LIST_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
