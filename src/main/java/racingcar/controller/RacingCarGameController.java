package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RacingCarGameController {

    private List<Car> cars;
    private Integer movingCount;

    public RacingCarGameController() {
    }

    public void racingCarGameStart() {
        racingCarGameInit();

        racingCarGameRun();

        racingCarGameResult();
    }

    private void racingCarGameInit() {
        OutputView.racingCarOpeningComment();
        cars = InputView.getCarNames();

        OutputView.tryCountInputComment();
        movingCount = InputView.getMovingCount();
    }

    private void racingCarGameRun() {
        OutputView.racingCarResultComment();

        for (int i = 0; i < movingCount; i++) {
            cars.forEach(car -> {
                car.tryAddMove();
                OutputView.racingCarResultPrint(car.getName(), car.getMovePosition());
            });
            OutputView.println();
        }
    }

    private void racingCarGameResult() {
        int maxPos = cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .orElseGet(() -> 0);

        String[] winnerArr = cars.stream()
                .filter(car -> car.carEqualsMaxDistance(maxPos))
                .map(Car::getName)
                .toArray(String[]::new);

        OutputView.racingCarWinnerPrint(winnerArr);
    }
}
