package racingcar.controller;

import racingcar.model.domain.Game;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();

    private RacingCarController() {
    }

    public static RacingCarController create() {
        return new RacingCarController();
    }

    public void startGame() {
        Game game = getGame();
    }

    private Game getGame() {
        CarRequestDto carRequestDto = inputView.setCarNames();
        GameRequestDto gameRequestDto = inputView.setGameTrial();
        return gameRequestDto.toGame(carRequestDto.toCar());
    }
}
