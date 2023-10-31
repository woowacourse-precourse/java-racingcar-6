package racingcar.controller;

import java.util.List;
import racingcar.domain.Manager;
import racingcar.domain.Player;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final OutputView outputView;
    private final InputView inputView;
    private final Manager manager;

    public Game(OutputView outputView, InputView inputView, Manager manager) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.manager = manager;
    }

    public void start() {
        outputView.printGameStart();
        List<String> inputString = inputView.inputPlayerList();

        outputView.printGameCount();
        int gameCount = inputView.inputGameCount();

        List<Player> playerList = manager.convertStringListToPlayerList(inputString);

        outputView.printGameResult();

        for (int i = 0; i < gameCount; i++) {
            manager.calculateRun(playerList);
            outputView.printPartialResults(playerList);
        }

        List<String> winners = manager.getWinners(playerList);
        outputView.printFinalResults(winners);
    }
}
