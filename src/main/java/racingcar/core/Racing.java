package racingcar.core;

import java.util.List;

import racingcar.util.StringUtils;

public class Racing {

    private List<Car> cars;
    private int raceCount;

    public void registerCarsByName(List<String> carNames) {
        validateNotNull(carNames);
        this.cars = createCars(carNames);
        validateMinimumCars();
    }

    private void validateMinimumCars() {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차를 등록해야 합니다.");
        } else if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차를 최소 2대 등록해야 합니다.");
        }
    }

    private void validateNotNull(Object input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값은 null 일 수 없습니다.");
        }
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public void registerRaceCount(int raceCount) {
        this.raceCount = raceCount;
        validateRaceCount();
    }

    private void validateRaceCount() {
        if (raceCount < 1) {
            throw new IllegalArgumentException("경주 횟수는 양수여야 합니다.");
        }
    }

    public void doRace() {
        validateMinimumCars();
        validateRaceCount();
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            doRaceOnce();
        }
    }

    private void doRaceOnce() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getCurrentStatusString());
        }
        System.out.println();
    }

    public void printWinner() {
        validateMinimumCars();
        final List<String> winnerNames = getWinners().stream().map(Car::getName).toList();
        final String winnerNamesString = StringUtils.joinByComma(winnerNames);
        System.out.println(String.format("최종 우승자 : %s", winnerNamesString));
    }

    private List<Car> getWinners() {
        validateMinimumCars();
        validateRacingStarted();
        final int maxForwardCount = getMaxForwardCount();
        return cars.stream().filter(car -> car.getForwardCount() == maxForwardCount).toList();
    }

    private int getMaxForwardCount() {
        return cars.stream().map(Car::getForwardCount).max(Integer::compareTo).orElse(0);
    }

    private void validateRacingStarted() {
        for (Car car : cars) {
            if (car.getTrialCount() <= 0) {
                throw new IllegalArgumentException("경주를 먼저 진행해야 합니다.");
            }
        }
    }
}
