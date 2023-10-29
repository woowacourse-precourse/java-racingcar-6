package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.CarMovement;
import racingcar.domain.CarStore;
import racingcar.dto.Car;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

public class GameController {
    private static final InputVeiw inputView = new InputVeiw();
    private static final CarStore carStore = CarStore.getInstance();

    private int MAX_CAR_NUMBER;
    private int MAX_ROUND;
    private int currentRound;
    private final int ZERO = 0;

    public void run() {
        getCarNameInput(inputView.inputCarName());
        getTotalRoundInput(inputView.inputRoundNumber());

        startGame();
    }

    private void getCarNameInput(List<String> carList) {
        MAX_CAR_NUMBER = carList.size();
        IntStream.range(ZERO, MAX_CAR_NUMBER)
                .mapToObj(id -> new Car(carList.get(id), ZERO))
                .forEach(carStore::saveCarInfo);
    }

    private void getTotalRoundInput(Integer integer) {
        MAX_ROUND = integer;
    }

    private void startGame() {
        do {
            increaseCurrentRound();
            startRound();
        } while (getCurrentRound() < MAX_ROUND);

        OutputView.printGameWinner(carStore.getAllCarInfo());
    }

    private void startRound() {
        carStore.getAllCarInfo().stream()
                .map(currentCar -> (new CarMovement(currentCar)).car())
                .forEach(OutputView::printStatusOfRaceCar);
        System.out.println();
    }

    public void increaseCurrentRound() {
        currentRound++;
    }

    public int getCurrentRound() {
        return currentRound;
    }

}