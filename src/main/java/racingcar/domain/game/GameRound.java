package racingcar.domain.game;

import racingcar.domain.car.CarInfo;
import racingcar.domain.car.CarMovement;
import racingcar.dto.Round;
import racingcar.view.OutputView;

public class GameRound {
    private static final CarInfo carInfo = CarInfo.getInstance();
    private Round gameRound;

    public GameRound(Round currentRound) {
        gameRound = currentRound;
    }

    public void passRound() {
        this.gameRound = new Round(gameRound.round() + 1);
    }

    public void startRound() {
        carInfo.getAllCarInfo().stream()
                .map(currentCar -> (new CarMovement(currentCar)).car())
                .forEach(OutputView::printStatusOfRaceCar);
        System.out.println();
    }

    public int getCurrentRound() {
        return gameRound.round();
    }
}
