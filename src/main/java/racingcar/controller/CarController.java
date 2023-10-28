package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RandomNumbers;
import racingcar.view.InputView;

import static racingcar.view.OutputView.gameStartMessage;
import static racingcar.view.OutputView.eachResultMessgae;
import static racingcar.view.OutputView.inputCountMessage;
import static racingcar.view.OutputView.startRacingMessage;
import static racingcar.view.OutputView.printWinner;

public class CarController {
    private final Cars cars = new Cars();
    private final InputView inputView = new InputView();
    private Integer countNumber = 0;
    private List<String> stringList = new ArrayList<>();

    public void welcome() {
        gameStartMessage();
    }

    public void registerRacer() {
        stringList = inputView.inputCars();
        cars.setCarsName(stringList);
    }

    public void setRacingCount() {
        inputCountMessage();
        countNumber = inputView.inputCountNumber();
    }

    public void startRacing() {
        startRacingMessage();
    }

    public void inRacing() {
        for (int i = 0; i < countNumber; i++) {
            RandomNumbers randomNumbers = new RandomNumbers(stringList.size());

            cars.ifForwardCars(randomNumbers.getRandomNumberList());

            eachResultMessgae(cars.toString());
        }
    }

    public void endRacing() {

        printWinner(cars.chooseWinner());

    }
}
