package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private final List<Car> raceCarList = new ArrayList<>();
    private int attempts = 0;

    public void startRace() {
        prepareRace();
        runRace();
        List<String> winners = determineWinner(raceCarList);
        OutputView.showWinner(winners);
        Console.close();
    }

    private void prepareRace() {
        String input = InputView.getCarNames();
        List<String> carNames = InputValidator.validateCarNames(input);
        generateRaceCarList(carNames);
        input = InputView.getNumberOfAttempts();
        attempts = InputValidator.validateNumberOfAttempts(input);
    }

    private void runRace() {
        OutputView.showResultTitle();
        for (int i = 0; i < attempts; i++) {
            runRaceRound();
        }
    }

    private void runRaceRound() {
        for (Car car : raceCarList) {
            car.moveOnRandomChance();
        }
        OutputView.showResult(raceCarList);
    }

    private void generateRaceCarList(List<String> carNames) {
        for (String carName : carNames) {
            raceCarList.add(new Car(carName));
        }
    }

    public List<String> determineWinner(List<Car> raceCarList) {
        List<String> winners = new ArrayList<>();
        int maxDistance = -1;
        for (Car car : raceCarList) {
            int carDistance = car.getDistance().length();
            if (carDistance > maxDistance) {
                maxDistance = carDistance;
                winners.clear();
            }
            if (carDistance == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
