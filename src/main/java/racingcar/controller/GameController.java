package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
import racingcar.domain.MovingStrategy;
import racingcar.util.RandomNumberUtil;
import racingcar.util.RandomNumberUtilImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;
    private Cars cars;
    private RaceRound raceRound;


    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        createCars();
        createRaceRound();
        playEachRaceRound();
        showWinner();
    }

    private void createCars() {
        try {
            final List<String> names = inputView.inputNames();
            final List<Car> carList = createCarList(names);
            cars = new Cars(carList);
        } catch (Exception e) {
            outputView.outputErrorMessage(e.getMessage());
        }
    }

    private List<Car> createCarList(final List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(movingStrategy, name));
        }

        return carList;
    }

    private void createRaceRound() {
        try {
            final Integer countOfRaceRound = inputView.inputCountOfGameRound();
            raceRound = new RaceRound(countOfRaceRound, 0);
        } catch (Exception e) {
            outputView.outputErrorMessage(e.getMessage());
        }
    }

    private void playEachRaceRound() {
        outputView.outputGameResultMessage();
        while (raceRound.isLeftRound()) {
            cars.raceAllCars();
            outputView.outputCarsPosition(cars.getCars());
            raceRound.increaseCurrentRound();
        }
    }

    private void showWinner() {
        final Integer winnerPosition = cars.findWinnerPosition();
        final List<Car> winner = cars.findWinner(winnerPosition);
        outputView.outputWinner(winner);
    }


}
