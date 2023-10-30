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
    private static Game game;

    private RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
        run();
    }

    public static void create() {
        new RacingCarController(new RacingCarServiceImp());
    }

    private void run() {
        initializeGame();
        startGame();
        showGameWinner();
    }

    private static void initializeGame() {
        CarRequestDto carRequestDto = InputView.setCarNames();
        GameRequestDto gameRequestDto = InputView.setGameTrial();
        game = gameRequestDto.toGame(carRequestDto.toCar());
    }

    private void startGame() {
        OutputView.printGameResult();
        while (!game.isFinished()) {
            racingCarService.moveCars(game);
            showGameScore();
        }
    }

    private static void showGameScore() {
        for (Car car : game.getCars()) {
            OutputView.printGameScore(new GameResponseDto(car));
        }
        OutputView.printJumpLine();
    }

    private void showGameWinner() {
        OutputView.printWinner(new CarResponseDto(racingCarService.getWinner(game)));
    }
}
