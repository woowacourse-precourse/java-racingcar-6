package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import racingcar.model.Player;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final LinkedList<Player> players = new LinkedList<>();
    private static int MAX = 0;
    public void racingReady() {
        outputView.inputNames();
        String[] names = inputView.inputPlayers();
        savePlayers(names);
        outputView.inputTimes();
        racingStart(inputView.inputTimes());
        outputView.printWinner(winner());
    }

    private int times() {
        outputView.inputTimes();
        return inputView.inputTimes();
    }

    private ArrayList<String> winner() {
        ArrayList<String> winner = new ArrayList<>();
        for (Player player : players) {
            if (!player.isWinner(MAX)) continue;
            winner.add(player.getName());
        }
        return winner;
    }

    private void racingStart(final int inputTimes) {
        outputView.printResult();
        for (int i = 0; i < inputTimes; i++) {
            System.out.println();
            move();
        }
    }

    private void move() {
        boolean flag = false;
        for (Player player : players) {
            flag |= player.ForwardOrNot();
            outputView.printPlayerStatus(player.getStatus());
        }
        if (flag) MAX++;
    }

    private void savePlayers(String[] names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }
}
