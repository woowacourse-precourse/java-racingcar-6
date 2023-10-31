package racingcar.domain.game;

import racingcar.domain.car.CarInfo;
import racingcar.domain.car.CarMovement;
import racingcar.dto.Round;
import racingcar.view.OutputView;

public class GameRound {
    private static final CarInfo carInfo = CarInfo.getInstance();
    
    private Round currentRound;

    public GameRound(Round round) {
        currentRound = round;
    }

    public void passRound() {
        this.currentRound = new Round(currentRound.round() + 1);
    }

    public void startRound() {
        carInfo.getAllCarInfo().stream()
                .map(currentCar -> (new CarMovement(currentCar)).car())
                .forEach(OutputView::printStatusOfRaceCar);
    }

    public int getCurrentRound() {
        return currentRound.round();
    }

}
