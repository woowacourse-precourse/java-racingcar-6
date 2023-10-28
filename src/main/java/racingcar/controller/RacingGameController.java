package racingcar.controller;


import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public RacingGameController(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void gameStart() {
        String carNames = inputView.inputCarName();
        Integer tryCount = inputView.inputTryCount();

        Cars cars = initRacingCars(carNames);

        progressGame(cars, tryCount);

        checkWinner(cars);
    }

    private void checkWinner(Cars cars) {
        List<String> winners = referee.checkResult(cars);
        outputView.printWinner(winners);
    }

    private void progressGame(Cars cars, Integer tryCount) {
        outputView.printResultMessage();
        while (tryCount-- > 0) {
            for (Car car : cars.getCars()) {
                car.move();
            }
            outputView.printMoveResult(cars);
        }
    }

    private Cars initRacingCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> carList = new ArrayList<>();
        RandomNumber randomNumber = new RandomNumber();

        for (String name : names) {
            carList.add(new Car(name, 0, randomNumber));
        }

        return new Cars(carList);
    }
}
