package racingcar;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, Player player, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.player = player;
        this.gameService = gameService;
    }

    public void play() {
        racingCarGamePlayerInput();
        player.settingCarNames(player.getCarNameStore());
        printCarStatus();
        finishGameResult();
    }

    private void racingCarGamePlayerInput() {
        printRequestInputCarName();
        settingPlayerCarNames();
        printRequestInputTryNumber();
        settingPlayerTryNumber();
    }

    private void printRequestInputCarName() {
        outputView.printRequestInputCarName();
    }

    private void settingPlayerCarNames() {
        player.settingPlayerCarNameStore(inputView.inputPlayerCarName());
    }

    private void printRequestInputTryNumber() {
        outputView.printRequestInputTryNumber();
    }

    private void settingPlayerTryNumber() {
        player.settingPlayerTryNumber(inputView.inputPlayerTryNumber());
    }

    private void printCarStatus() {
        printPlayResult();
        carStatusLoop();
    }

    private void printPlayResult() {
        outputView.printGameResult();
    }

    private void carStatusLoop() {
        for (int i = 0; i < player.getTryNumber(); i++) {
            getCarMove();
            outputView.printEmptyLine();
        }
    }

    private void getCarMove() {
        for (Car car : getPlayerCar()) {
            gameService.move(car);
        }
    }

    private List<Car> getPlayerCar() {
        return player.getCars();
    }

    private void finishGameResult() {
        gameService.getMaxPosition(getPlayerCar());
        outputView.printCarGameWinnerName(gameService.findGameWinner(getPlayerCar()));
    }
}
