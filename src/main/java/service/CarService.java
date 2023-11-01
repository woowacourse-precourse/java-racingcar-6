package service;

import camp.nextstep.edu.missionutils.Randoms;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

public class CarService {
    private final CarActionHandler carActionHandler;

    public CarService() {
        this.carActionHandler = new CarActionHandler();
    }

    public void init(String carList) {
        carActionHandler.init(carList);
    }

    public void playRound(int rounds) {
        OutputView.startPlayDisplay();

        for (int round = 0; round < rounds; round++) {
            playSingleRound();
            singleRoundDisplay();
        }
        winnerSetAndDisplay();
    }

    public void playSingleRound() {
        LinkedHashMap<String, Integer> shouldMoveList = carActionHandler.getCarList();
        shouldMoveList.forEach((carName, distance) -> moveCarIfPossible(carName));
    }

    private void moveCarIfPossible(String carName) {
        if (isCarMoving()) {
            carActionHandler.forwardCar(carName);
        }
    }

    private void singleRoundDisplay() {
        OutputView.displayRaceResult(carActionHandler.getCarList());
    }

    public void winnerSetAndDisplay() {
        List<String> winnerList = RaceWinnerAnalyzer.determineWinner(carActionHandler.getCarList());
        OutputView.displayWinners(winnerList);
    }

    public static boolean isCarMoving() {
        int randomPick = Randoms.pickNumberInRange(0, 9);
        return randomPick >= 4;
    }
}
