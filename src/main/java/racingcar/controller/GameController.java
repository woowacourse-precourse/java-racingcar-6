package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.CarInfo;
import racingcar.domain.game.GameRound;
import racingcar.dto.Car;
import racingcar.dto.Round;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

public class GameController {
    private static final InputVeiw inputView = new InputVeiw();
    private static final CarInfo carInfo = CarInfo.getInstance();

    private int MAX_CAR_NUMBER;
    private int MAX_ROUND;
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
                .forEach(carInfo::saveCarInfo);
    }

    private void getTotalRoundInput(Integer integer) {
        MAX_ROUND = integer;
    }

    private void startGame() {
        GameRound gameRound = new GameRound(new Round(ZERO));
        do {
            gameRound.passRound();
            gameRound.startRound();
        } while (gameRound.getCurrentRound() < MAX_ROUND);

        OutputView.printGameWinner(carInfo.getAllCarInfo());
    }
}