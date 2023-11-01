package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public RaceGameController(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void play() {
        List<Car> carList = inputView.getCarNameList().stream()
                .map(Car::new).toList();
        int roundTime = inputView.getRoundTime();

        while (roundTime-- > 0) {
            carList.forEach(car -> {
                int randomNumber = RandomNumber.generateRandomNumber();
                if (randomNumber > Car.MOVE_FORWARD_THRESHOLD) {
                    car.moveForward();
                }
            });

            outputView.printRoundResult(carList);
        }

        List<Car> winnerList = referee.getWinner(carList);
        outputView.printWinner(winnerList);
    }
}
