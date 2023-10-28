package racingcar.core;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.StringUtils;

public class Racing {

    private List<Car> cars;
    private int raceCount;

    public void play() {
        registerCars();
        registerRaceCount();
        doRace();
        printWinner();
    }

    public void registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String line = Console.readLine();
        final List<String> carNames = StringUtils.splitByComma(line);
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private void registerRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        final String line = Console.readLine();
        int raceCount = StringUtils.parseInt(line);
        validateRaceCount(raceCount);
        this.raceCount = raceCount;
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("경주 횟수는 양수여야 합니다.");
        }
    }

    private void doRace() {
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

    private void printWinner() {
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
