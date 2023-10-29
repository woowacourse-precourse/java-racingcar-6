package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Player;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final ArrayList<Player> players = new ArrayList<>();

    public void racingProcess() {
        savePlayers();
        racingStart(times());
        outputView.printWinner(winner());
    }

    private int times() {
        outputView.inputTimes();
        return inputView.inputTimes();
    }

    private ArrayList<String> winner() {
        ArrayList<String> winner = new ArrayList<>();
        for (Player player : players) {
            if (!player.isWinner()) continue;
            winner.add(player.getName());
        }
        return winner;
    }

    private void racingStart(final int times) {
        outputView.printResult();
        for (int i = 0; i < times; i++) {
            System.out.println();
            move();
        }
    }

    private void move() {
        for (Player player : players) {
            player.ForwardOrNot();
            outputView.printPlayerStatus(player);
        }
    }

    private void savePlayers() {
        outputView.inputNames();
        for (String name : inputView.inputPlayers()) {
            Player p = new Player(name);
            players.add(p);
        }
    }
}
