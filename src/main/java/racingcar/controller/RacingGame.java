package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarName;
import racingcar.model.RandomNumber;
import racingcar.model.TryNumber;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarName carName;
    TryNumber tryNumber;
    RandomNumber randomNumber;
    Winner winner;
    private int[] ranking;
    private int tryNum;
    private ArrayList<String> cars = new ArrayList<>();


    public RacingGame() {
        carName = new CarName();
        tryNumber = new TryNumber();
        randomNumber = new RandomNumber();
        winner = new Winner();
    }

    public void start() {
        InputCarNames();
        getTryNumber();
        onRacing(cars, tryNum);
        setWinner(ranking, cars);

    }

    public void InputCarNames() {
        String inputCarNames = inputView.InputCarNames();
        carName.carNamesToList(inputCarNames);
        carName.setClearCarList();
        this.cars = carName.getClearCarList();
    }

    public void getTryNumber() {
        String tryNum = inputView.InputTryNumber();
        tryNumber.setClearTryNumber(tryNum);
        this.tryNum = tryNumber.getTryNumber();
    }

    public int[] getCurrentRanking() {
        return ranking;
    }

    public void onRacing(ArrayList<String> cars, int tryNumber) {
        ranking = new int[cars.size()];
        for (int i = 0; i < tryNumber; i++) {
            carForwarding(cars);
            outputView.printCurrentRanking(getCurrentRanking(), cars);

        }
    }

    public void setWinner(int[] ranking, ArrayList<String> cars) {
        winner.decideWinner(ranking, cars);
        outputView.printWinner(winner.getWinnerList());
    }

    public boolean isGo() {
        int go = 0;
        randomNumber.generateRandomNumber();
        go = randomNumber.getRandomNumber();
        if (go >= 4) {
            return true;
        }
        return false;
    }

    public void carForwarding(ArrayList<String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (isGo()) {
                ranking[i]++;
            }
        }
    }
}
