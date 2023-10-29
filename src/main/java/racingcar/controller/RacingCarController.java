package racingcar.controller;

import racingcar.model.domain.Game;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;
import racingcar.model.service.RacingCarService;
import racingcar.model.service.RacingCarServiceImp;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final RacingCarService racingCarService = new RacingCarServiceImp();

    private RacingCarController() {
    }

    public static RacingCarController create() {
        return new RacingCarController();
    }

    public void startGame() {
        Game game = initializeGame();
        while (!racingCarService.isEnd(game)) {
            racingCarService.moveCars(game);
        }
    }

    private Game initializeGame() {
        CarRequestDto carRequestDto = inputView.setCarNames();
        GameRequestDto gameRequestDto = inputView.setGameTrial();
        return gameRequestDto.toGame(carRequestDto.toCar());
    }
}
