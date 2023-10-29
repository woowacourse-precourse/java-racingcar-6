package racingcar;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Player player = new Player();

    public void play() {
        racingCarGamePlayerInputInfo();
    }

    private void racingCarGamePlayerInputInfo() {
        printRequestInputCarName();
        settingPlayerCarNames();
        printRequestInputTryNumber();
        settingPlayerTryNumber();
    }

    private void settingPlayerCarNames() {
        player.settingPlayerCarNameStore(inputView.inputPlayerCarName());
    }

    private void settingPlayerTryNumber() {
        player.settingPlayerTryNumber(inputView.inputPlayerTryNumber());
    }

    private void printRequestInputCarName() {
        outputView.printRequestInputCarName();
    }

    private void printRequestInputTryNumber() {
        outputView.printRequestInputTryNumber();
    }
}
