package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        List<String> carNames = inputView.readRacingCars();
        int totalRounds = inputView.readAttemptsNumber();
        RacingGame racingGame = new RacingGame(carNames, totalRounds);
        for (int i = 0; i < totalRounds; i++) {
            racingGame.moveCars();
            List<RacingCar> racingCars = racingGame.getRacingCars();
//            for(int j=0;j<racingCars.size();j++) {
//                System.out.println(racingCars.get(i).getName() + " = " + racingCars.get(i).getPosition());
//            }
        }

    }
}
