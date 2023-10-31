package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Players;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    private static final int RACE_COUNT_MINIMUM = 1;
    private static final String NAME_SEPARATOR = ",";

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        String carsName = inputView.readCarsName();
        Players players = createCarList(carsName);

        int raceCount = inputView.readCarMoveCount();
        validateRaceCount(raceCount);
        outputView.printRaceStart();

        race(players, raceCount);
        announceWinner(players);
    }

    private Players createCarList(String carsName) {
        List<String> carNameList = Arrays.asList(carsName.split(NAME_SEPARATOR));
        return new Players(carNameList);
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < RACE_COUNT_MINIMUM) {
            throw new IllegalArgumentException();
        }
    }

    private void race(Players players, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : players.getCars()) {
                car.move(NumberGenerator.createRandomNumber());
            }
            outputView.printRacePlayers(players.getCars());
        }
    }

    private void announceWinner(Players players) {
        List<String> winnerList = players.findWinner();
        outputView.printWinner(winnerList);
    }
}
