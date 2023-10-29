package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void race(){
        start();
    }

    private void start(){
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars(inputView.getCars());
        racingCar.updateRaceCount(inputView.getRaceCount());

        outputView.printRaceResult();
        for (int i = 0; i < racingCar.getRaceCount(); i++) {
            Game game = new Game();
            game.generateRaceResult(racingCar.getCars().size());
        }


    }
}
