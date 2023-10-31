package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.service.GameService;
import racingcar.view.InputValue;
import racingcar.view.OutputValue;


public class GameController {

    private RacingCars racingCars = new RacingCars();

    private GameService gameService = new GameService();

    private int range;

    public GameController() {
        gameInit();
        gameStart();
        gameEnd();
    };

    private void gameInit() {

        OutputValue.getNamesMessage();

        String[] result = InputValue.getRacingCarsNames();

        racingCars.setCars(result);

        OutputValue.getRangeMessage();

        range = InputValue.getRacingRange();

    }

    private void gameStart() {

        OutputValue.executionResultMessage();

        for(int i = 0; i < range; i++) {
            gameService.gameProgress(racingCars);
            OutputValue.gameProgressMessage(racingCars);
        }

    }

    private void gameEnd() {

        gameService.getWinnerNames(racingCars);

        OutputValue.gameResultMessage(racingCars);
    }

}
