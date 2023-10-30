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
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
            if (randomNum >= MOVE_FORWARD_NUM) {
                car.moveForward();
            }
        }
    }

    private void printResult() {
        cars.forEach(car -> {
            outputView.print(car.getName() + PRINT_DISTANCE_SEPARATOR);
            for (int i = 0; i < car.getDistance(); i++) {
                outputView.print(DISTANCE);
            }
            outputView.lineBreak();
        });
        outputView.lineBreak();
    }

    private void printWinner() {
        int winnerDistance = getMaxDistance();

        outputView.print(FINAL_WINNER_MESSAGE);
        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == winnerDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        String result = String.join(RESULT_JOIN_SEPARATOR, winners);
        outputView.print(result);
    }

    private int getMaxDistance() {
        int maxDistance = -1;
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }
}