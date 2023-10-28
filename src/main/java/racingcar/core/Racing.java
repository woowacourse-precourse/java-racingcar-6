package racingcar.core;

import java.util.List;
import racingcar.util.StringUtils;

public class Racing {

    private List<Car> cars;
    private int raceCount;

    public void registerCarsByName(List<String> carNames) {
        validateNotNull(carNames);
        this.cars = createCars(carNames);
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
        validateRaceCount(raceCount);
        this.raceCount = raceCount;
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("경주 횟수는 양수여야 합니다.");
        }
    }

    public void doRace() {
        validateCarsNotEmpty();
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

    private void validateCarsNotEmpty() {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차를 등록해야 합니다.");
        }
    }

    public void printWinner() {
        validateCarsNotEmpty();
        final List<String> winnerNames = getWinners().stream().map(Car::getName).toList();
        final String winnerNamesString = StringUtils.joinByComma(winnerNames);
        System.out.println(String.format("최종 우승자 : %s", winnerNamesString));
    }

    private List<Car> getWinners() {
        validateCarsNotEmpty();
        final int maxForwardCount = getMaxForwardCount();
        return cars.stream()
            .filter(car -> car.getForwardCount() == maxForwardCount)
            .toList();
    }

    private int getMaxForwardCount() {
        return cars.stream().map(Car::getForwardCount).max(Integer::compareTo).orElse(0);
    }
}
