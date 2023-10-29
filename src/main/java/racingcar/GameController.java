package racingcar;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Player player = new Player();
    private final GameService gameService = new GameService();

    public void play() {
        racingCarGamePlayerInputInfo();
        player.settingCarNames(player.getCarNameStore());
        printCarStatus();
        finishGameResult();
    }

    private void racingCarGamePlayerInputInfo() {
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
        outputView.printPlayResult();
    }

    private void carStatusLoop() {
        for (int i = 0; i < player.getTryNumber(); i++) {
            for (Car car : getPlayerCarInfo()) {
                gameService.move(car);
            }
            outputView.space();
        }
    }

    private List<Car> getPlayerCarInfo() {
        return player.getCarInfo();
    }

    private void finishGameResult() {
        gameService.getMaxPosition(getPlayerCarInfo());
        outputView.printCarGameWinnerName(gameService.findGameWinner(getPlayerCarInfo()));
    }
}
