package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRunner {
    public void start() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int rounds = InputView.getRounds();
        RaceResult raceResult = new RaceResult(cars);

        System.out.println("\n실행 결과");
        IntStream.range(0, rounds).forEach(i -> {
            moveCars(cars);
            raceResult.addRoundResult(cars);
            OutputView.displayRoundProgress(cars);
        });

        OutputView.displayWinners(raceResult.getWinners());
    }

    private void moveCars(List<Car> cars) {
        cars.forEach(Car::move);
    }
}
