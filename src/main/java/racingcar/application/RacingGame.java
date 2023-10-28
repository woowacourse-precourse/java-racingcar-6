package racingcar.application;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.contants.RacingGameConstants;
import racingcar.domain.Car;
import racingcar.util.GameResult;

public class RacingGame {
    public void start() {
        String inputCarNames = getCarNamesFromUserInput();
        int count = getAttemptCountFromUserInput();
        List<Car> cars = createCars(inputCarNames);
        runRace(count, cars);
    }

    private String getCarNamesFromUserInput() {
        System.out.println(RacingGameConstants.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    private int getAttemptCountFromUserInput() {
        System.out.println(RacingGameConstants.ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private void runRace(int count, List<Car> cars) {
        System.out.println(RacingGameConstants.EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            moveCars(cars);
            GameResult.result(cars);
            System.out.println();
        }
        GameResult.finalResult(calculateWinners(cars));
    }

    private void moveCars(List<Car> cars) {
        cars.forEach(car -> car.moveAccordingToInput(Randoms.pickNumberInRange(1, 9)));
    }

    public List<Car> createCars(String inputCarNames) {
        String[] split = inputCarNames.split(RacingGameConstants.DELIMITER);
        return Arrays.stream(split)
                .map(inputCarName -> new Car(inputCarName))
                .collect(Collectors.toList());
    }

    public List<String> calculateWinners(List<Car> cars) {
        return findWinners(cars, getMaxMovingCount(cars));
    }

    private static List<String> findWinners(List<Car> cars, int maxCount) {
        return cars.stream()
                .filter(car -> car.getMovingCount() == maxCount)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private Integer getMaxMovingCount(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();
    }
}
