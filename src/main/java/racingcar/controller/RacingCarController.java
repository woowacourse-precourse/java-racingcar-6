package racingcar.controller;

import racingcar.model.domain.Game;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.CarResponseDto;
import racingcar.model.dto.GameRequestDto;
import racingcar.model.dto.GameResponseDto;
import racingcar.model.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        Game game = initializeGame();
        startGame(game);
        showGameWinner(game);
    }

    private Game initializeGame() {
        CarRequestDto carRequestDto = InputView.getCarNames();
        GameRequestDto gameRequestDto = InputView.getGameTrial();
        return gameRequestDto.toGame(carRequestDto.toCar());
    }

    private void startGame(Game game) {
        OutputView.printGameResult();
        while (!game.isFinished()) {
            racingCarService.moveCars(game);
            showGameScore(game);
        }
    }

    private void showGameScore(Game game) {
        game.getCars().forEach(car -> OutputView.printGameScore(new GameResponseDto(car)));
        OutputView.printJumpLine();
    }

    private void showGameWinner(Game game) {
        OutputView.printWinner(new CarResponseDto(racingCarService.getWinner(game)));
    }
}
