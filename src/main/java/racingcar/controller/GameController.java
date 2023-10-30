package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.domain.Referee.findMostProgressCar;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        String carsName = inputView.readCarsName();
        List<Car> carList = createCarList(carsName);

        int raceCount = inputView.readCarMoveCount();
        for (int i = 0; i < raceCount; i++) {
            for (Car car : carList) {
                car.move(NumberGenerator.createRandomNumber());
            }
            outputView.printCarsProgress(carList);
        }

        announceWinner(carList);
    }

    private List<Car> createCarList(String carsName) {
        return null;
    }

    private void announceWinner(List<Car> carList) {
        List<String> winnerList = Referee.findMostProgressCar(carList);
        outputView.printWinner(winnerList);
    }
}
