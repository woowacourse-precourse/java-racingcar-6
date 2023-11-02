package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Garage;
import racingcar.domain.RaceCount;
import racingcar.domain.Winner;
import racingcar.domain.Circuit;
import racingcar.view.OutputView;
import racingcar.view.InputView;

import java.util.List;

public class RacingGame {

    private Circuit circuit;

    public RacingGame(Circuit circuit) {
        this.circuit = circuit;
    }

    public void start() {
        List<Car> cars = getCarList();
        int remainingRace = getRaceCount();
        OutputView.printConsole();
        do {
            race(cars);
        } while (remainingRace-- > 1);
        printGameWinner(cars);
    }

    private List<Car> getCarList() {
        String playerInput = InputView.getCarNamesFromPlayerInput();
        Garage garage = new Garage(playerInput);
        return garage.getCarList();
    }

    private int getRaceCount() {
        String countInput = InputView.getRaceCountFromPlayerInput();
        RaceCount raceCount = new RaceCount(countInput);
        return raceCount.getCount();
    }

    private void race(List<Car> cars) {
        circuit.race(cars);
        OutputView.printGameResult(cars);
    }

    private void printGameWinner(List<Car> cars) {
        Winner winner = new Winner(cars);
        List<String> gameWinners = winner.getWinners();
        OutputView.printGameWinner(gameWinners);
    }
}