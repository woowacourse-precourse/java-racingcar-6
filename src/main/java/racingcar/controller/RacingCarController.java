package racingcar.controller;

import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.CarResponseDto;
import racingcar.model.dto.GameRequestDto;
import racingcar.model.dto.GameResponseDto;
import racingcar.model.service.RacingCarService;
import racingcar.model.service.RacingCarServiceImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private Game game;

    private RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public static RacingCarController create() {
        return new RacingCarController(new RacingCarServiceImp());
    }

    public void startGame() {
        initializeGame();
        OutputView.printGameResult();
        while (!game.isFinished()) {
            racingCarService.moveCars(game);
            showGameScore();
        }
        showGameWinner();
    }

    private void initializeGame() {
        CarRequestDto carRequestDto = InputView.setCarNames();
        GameRequestDto gameRequestDto = InputView.setGameTrial();
        game = gameRequestDto.toGame(carRequestDto.toCar());
    }

    private void showGameScore() {
        for (Car car : game.getCars()) {
            OutputView.printGameScore(new GameResponseDto(car));
        }
        OutputView.printJumpLine();
    }

    private void showGameWinner() {
        OutputView.printWinner(new CarResponseDto(racingCarService.getWinner(game)));
    }
}
