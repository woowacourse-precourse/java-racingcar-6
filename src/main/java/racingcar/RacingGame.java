package racingcar;

import static racingcar.Constant.DISTANCE;
import static racingcar.Constant.FINAL_WINNER_MESSAGE;
import static racingcar.Constant.MAX_RANDOM_NUM;
import static racingcar.Constant.MIN_ATTEMPT_COUNT;
import static racingcar.Constant.MIN_RANDOM_NUM;
import static racingcar.Constant.MOVE_FORWARD_NUM;
import static racingcar.Constant.PRINT_DISTANCE_SEPARATOR;
import static racingcar.Constant.PRINT_RESULT_MESSAGE;
import static racingcar.Constant.RESULT_JOIN_SEPARATOR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private int attemptCount;
    private final OutputView outputView;

    public RacingGame(List<Car> cars, int attemptCount, OutputView outputView) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.lineBreak();
        outputView.print(PRINT_RESULT_MESSAGE);
        outputView.lineBreak();
        while (attemptCount-- >= MIN_ATTEMPT_COUNT) {
            moveCars();
            printResult();
        }
        printWinner();
    }

    private void moveCars() {
        cars.forEach(this::decideCarMotion);
    }

    private void decideCarMotion(Car car) {
        int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        if (randomNum >= MOVE_FORWARD_NUM) {
            car.moveForward();
        }
    }

    public void printResult() {
        cars.forEach(car -> {
            outputView.print(car.getName());
            outputView.print(PRINT_DISTANCE_SEPARATOR);
            outputView.print(DISTANCE.repeat(car.getDistance()));
            outputView.lineBreak();
        });
        outputView.lineBreak();
    }

    public void printWinner() {
        outputView.print(FINAL_WINNER_MESSAGE);
        int winnerDistance = getMaxDistance();
        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == winnerDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        String result = String.join(RESULT_JOIN_SEPARATOR, winners);
        outputView.print(result);
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}