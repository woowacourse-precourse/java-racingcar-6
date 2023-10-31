package racingcar.controller;

import racingcar.model.AttemptNum;
import racingcar.model.Game;
import racingcar.model.Move;
import racingcar.model.Name;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Name name = new Name();
    private final Move move = new Move();
    private final AttemptNum attemptNum = new AttemptNum();
    private final Map<String, String> distance = new HashMap<>();

    public void start() {
        List<String> players = Arrays.asList(inputView.name().split(","));
        name.isValid(players);
        String attemptsNum = inputView.attemptsNum();
        attemptNum.isValid(attemptsNum);
        outputView.initial();
        initializeDistanceMap(players);
        playGameRepeat(players, Integer.parseInt(attemptsNum));
        showWinner(findMaxEntry());
    }

    private void initializeDistanceMap(List<String> players) {
        for (String playerName : players) {
            distance.put(playerName, "");
        }
    }

    private void playGameRepeat(List<String> players, int attempts) {
        for (int i = 0; i < attempts; i++) {
            playGame(players);
        }
    }

    private void playGame(List<String> players) {
        for (String playerName : players) {
            int randomNum = move.generateRandom();
            Game game = new Game(randomNum);
            if (game.move()) {
                String currentDistance = distance.get(playerName);
                currentDistance += "-";
                distance.put(playerName, currentDistance);
            }
        }
        showResult();
    }

    private void showResult() {
        for (Map.Entry<String, String> entry : distance.entrySet()) {
            outputView.result(entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    private int findMaxEntry() {
        int maxEntry = 0;
        for (String distanceValue : distance.values()) {
            maxEntry = Math.max(maxEntry, distanceValue.length());
        }
        return maxEntry;
    }

    private void showWinner(int maxEntry) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, String> entry : distance.entrySet()) {
            if (entry.getValue().length() == maxEntry) {
                winners.add(entry.getKey());
            }
        }
        String winnerNames = String.join(", ", winners);
        outputView.winner(winnerNames);
    }
}