package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.InputValidation;
import racingcar.domain.Car;
import racingcar.util.RandomNumberGenerator;


import java.util.*;


public class GameController {
    int totalRound;
    List<Car> cars = new ArrayList<>();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void run() {
        setGame();
        playGame();
        endGame();
    }
    private void setGame() {
        String inputCarNames = inputView.CarName();
        setCars(inputCarNames);
        String inputGameRound = inputView.GameRound();
        setRound(inputGameRound);
    }
    public void playGame() {
        int runRound = 0;
        outputView.result();
        while (runRound < totalRound) {
            playCarRace();
            outputView.divideLine();
            runRound++;
        }
    }
    public void endGame() {
        outputView.winner(getWinners());
    }
    private void setCars(String inputCarNames) {
        String[] arrCarNames = inputCarNames.split(",");
        inputValidation.isVaildCarName(inputCarNames, arrCarNames);
        for (String carName : arrCarNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }
    private void setRound(String inputGameRound) {
        inputValidation.isVaildGameRound(inputGameRound);
        this.totalRound = Integer.parseInt(inputGameRound);
    }
    private void playCarRace() {
        for (Car car : cars) {
            if (randomNumberGenerator.getRandomNumber() > 4) {
                car.moveForward();
            }
            String printDinstance = MarkToMove(car.getMoveDistance());
            outputView.resultByRound(car.getName(), printDinstance);
        }
    }
    private String MarkToMove(Integer moveDistance) {
        String marking = "-";
        return marking.repeat(moveDistance);
    }
    private String getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveDistance() == maxDistance()) {
                winners.add(car.getName());
            }
        } return String.join(", ", winners);
    }
    private int maxDistance() {
        List<Integer> listMoveDistances = new ArrayList<>();
        for (Car car : cars) {
            listMoveDistances.add(car.getMoveDistance());
        }
        return Collections.max(listMoveDistances);
    }
}
