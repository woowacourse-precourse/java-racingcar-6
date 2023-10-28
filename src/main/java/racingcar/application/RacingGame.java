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
        System.out.println(RacingGameConstants.INPUT_CAR_NAMES_MESSAGE);
        String inputCarNames = Console.readLine();
        System.out.println(RacingGameConstants.ATTEMPT_COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());

        List<Car> cars = createCars(inputCarNames);
        System.out.println(RacingGameConstants.EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            cars.forEach(car -> car.moveAccordingToInput(Randoms.pickNumberInRange(1, 9)));
            GameResult.result(cars);
            System.out.println();
        }
        GameResult.finalResult(calculateWinners(cars));
    }

    public List<Car> createCars(String inputCarNames) {
        String[] split = inputCarNames.split(RacingGameConstants.DELIMITER);
        return Arrays.stream(split)
                .map(inputCarName -> new Car(inputCarName))
                .collect(Collectors.toList());
    }

    public List<String> calculateWinners(List<Car> cars) {
        int maxCount = cars.stream()
                .map(car -> car.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.getMovingCount() == maxCount)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
