package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.GameState;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Round {
    private final int roundLength;
    private static final int RANDOM_MAX_INT = 9;
    private static final int RANDOM_MIN_INT = 0;
    private static final int FORWARD_CRITERION = 4;
    private int maxDistance;
    private final OutputView outputView = new OutputView();

    public Round(int roundLength) {
        this.roundLength = roundLength;
        this.maxDistance = 0;
    }

    protected void playAllRound(ArrayList<Car> carList) {
        outputView.outputFirstLine();

        for (int i = 0; i < roundLength; i++) {
            playOneRound(carList);
        }

        afterAllRoundDisplayWinner(carList);
    }

    private void playOneRound(ArrayList<Car> carList) {
        for (Car car : carList) {
            decisionforward(car);
        }
        displayOneRound(carList);
    }

    private void decisionforward(Car car) {
        if (randomInt() >= FORWARD_CRITERION) {
            goForward(car);
        }
    }

    private void displayOneRound(ArrayList<Car> carList) {
        GameState gameState = new GameState(carList);
        outputView.displayResultPerRound(gameState);
    }

    public void afterAllRoundDisplayWinner(ArrayList<Car> carList) {
        ArrayList<Car> carWinnerList = selectWinner(carList);
        outputView.displayWinner(carWinnerList);
    }

    private ArrayList<Car> selectWinner(ArrayList<Car> carList) {
        ArrayList<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (isWinnerCar(car.getRaceLength())) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    private boolean isWinnerCar(int raceLength){
        return maxDistance == raceLength;
    }

    private void goForward(Car car) {
        car.plusOneStep();
        if (car.getRaceLength() > maxDistance) {
            maxDistance = car.getRaceLength();
        }
    }

    private int randomInt() {
        return Randoms.pickNumberInRange(RANDOM_MIN_INT, RANDOM_MAX_INT);
    }
}
