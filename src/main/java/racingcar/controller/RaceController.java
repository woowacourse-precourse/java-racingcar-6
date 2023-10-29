package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.dto.RaceResultResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void race(){
        RacingCar racingCar = setUp();
        outputView.printRaceResultMessage();
        for (int i = RaceConstant.START_INDEX; i < racingCar.getRaceCount(); i++) {
            Game game = new Game();
            List<Integer> raceResult = game.updateRaceResult(racingCar);
            RaceResultResponse response = new RaceResultResponse(racingCar.getCars(), raceResult);
            outputView.printRaceResult(response);
        }
    }

    private RacingCar setUp(){
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars(inputView.getCars());
        racingCar.updateRaceCount(inputView.getRaceCount());
        return racingCar;
    }
}
