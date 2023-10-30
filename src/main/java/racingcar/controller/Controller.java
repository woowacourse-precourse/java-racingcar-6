package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Car> carsList = new ArrayList<>(10);
    private int trial;

    public void run() {
        startGame();
        playGame();
        endGame();
    }

    public void startGame() {
        String[] carsList = inputView.inputCarsName();
        trial = Integer.parseInt(inputView.inputTrial());
        carGenerator(carsList);
    }

    public void playGame() {
        outputView.showResult();
        while (trial > 0) {
            moveCar();
            outputView.showRoundResult(carsList);
            trial--;
        }
    }

    public void endGame() {
        Winner winner = new Winner();
        winner.findWinner(carsList);
        List<String> winnerList = winner.getWinner();
        outputView.showWinner(winnerList);
    }

    public void carGenerator(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.putName(cars[i]);
            carsList.add(car);
        }
    }

    public void moveCar() {
        for (int i = 0; i < carsList.size(); i++) {
            Car car = carsList.get(i);
            int randNum = car.randomNumber();
            car.moveForward(randNum);
        }
    }

}
