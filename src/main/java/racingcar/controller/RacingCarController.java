package racingcar.controller;

import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;
import racingcar.model.dto.GameResponseDto;
import racingcar.model.service.RacingCarService;
import racingcar.model.service.RacingCarServiceImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarServiceImp();

    private RacingCarController() {
    }

    public static RacingCarController create() {
        return new RacingCarController();
    }

    public void startGame() {
        Game game = initializeGame();
        OutputView.printGameResult();
        while (!racingCarService.isEnd(game)) {
            racingCarService.moveCars(game);
            showGameScore(game);
        }
    }

    private Game initializeGame() {
        CarRequestDto carRequestDto = InputView.setCarNames();
        GameRequestDto gameRequestDto = InputView.setGameTrial();
        return gameRequestDto.toGame(carRequestDto.toCar());
    }

    private void showGameScore(Game game) {
        for (Car car : game.getCars()) {
            OutputView.printGameScore(new GameResponseDto(car));
        }
        OutputView.printJumpLine();
    }
}
