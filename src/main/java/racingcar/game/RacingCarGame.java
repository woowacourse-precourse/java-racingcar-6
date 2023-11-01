package racingcar.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
`import java.util.stream.IntStream;
import racingcar.car.Car;
import racingcar.utils.randomGenerator.RandomNumberGenerator;
import racingcar.utils.result.ResultGenerator;
import racingcar.utils.writer.Writer;

public class RacingCarGame {

    public static final int INIT_COUNT = 0;
    public static final int FORWARD_CONDITIONAL_VALUE = 4;
    public static final String EXECUTION_RESULT = "실행 결과";
    private final RandomNumberGenerator randomNumberGenerator;
    private final Writer writer;
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private List<Car> cars;


    public RacingCarGame(RandomNumberGenerator randomNumberGenerator, Writer writer) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.writer = writer;
    }

    public void play(List<String> carNames, int attemptCount) {
        initCars(carNames);
        display(EXECUTION_RESULT);
        executeRounds(attemptCount);
        display(resultGenerator.makeWinnersResult(getWinners()));
    }

    private void executeRounds(int attemptCount) {
        for (int round = INIT_COUNT; round < attemptCount; round++) {
            moveCarsForward();
            display(resultGenerator.makeExecutionResult(cars));
        }
    }

    private void display(String context) {
        writer.write(context);
    }

    private List<Car> getWinners() {
        int maxMoveCount = Collections
            .max(cars, Comparator.comparing(Car::getForwardMoveCount))
            .getForwardMoveCount();

        return cars.stream()
            .filter(car -> car.getForwardMoveCount() == maxMoveCount)
            .collect(Collectors.toList());
    }

    private void moveCarsForward() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomSingleDigit();
            if (randomNumber >= FORWARD_CONDITIONAL_VALUE) {
                car.move();
            }
        }
    }

    private void initCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

}
