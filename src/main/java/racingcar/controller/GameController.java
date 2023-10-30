package racingcar.controller;

import racingcar.model.Attempt;
import racingcar.model.Game;
import racingcar.model.Move;
import racingcar.model.Name;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class GameController {
    private final InputView inputView = new InputView();
    private final Name carName = new Name();
    private final Move move = new Move();
    private final Attempt attemptNum = new Attempt();
    private final OutputView outputView = new OutputView();
    HashMap<Object, String> distance = new HashMap<Object, String>();
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        carName.isValid(player);
        String attemptsNum = inputView.attemptsNum();
        attemptNum.isValid(attemptsNum);
        outputView.initial();
        for (Object playerName : player){
            this.distance.put(playerName,"");
        }
        for (int i = 0; i < Integer.parseInt(attemptsNum); i++) {
            playGame(player, this.distance);
        }
        showWinner(this.distance);
    }

    public void playGame(List player, HashMap distance) {
        for (Object playerName : player){
            int randomNum = move.generateRandom();
            Game game = new Game(randomNum);
            if (game.move()){
                String a = (String) distance.get(playerName);
                a+="-";
                distance.put(playerName,a);
            }
        }
        showResult(distance);
    }

    public void showResult(HashMap distance) {
        Set<Map.Entry<String, String>> result = distance.entrySet();
        for(Map.Entry<String, String> movement : result){
            String name = movement.getKey();
            String bar = movement.getValue();
            outputView.result(name, bar);
        }
        System.out.println();
    }

    public void showWinner(HashMap distance) {
        int maxEntry = 0;
        Set<Map.Entry<String, String>> entrySet = distance.entrySet();
        List<String> winnerName = new ArrayList<>();
        for (Map.Entry<String, String> entry : entrySet) {
            if (entry.getValue().length() > maxEntry) {
                maxEntry = entry.getValue().length();
            }
        }
        for (Map.Entry<String, String> entry : entrySet) {
            if (entry.getValue().length() == maxEntry) {
                winnerName.add(entry.getKey());
            }
        }
        String winners = String.join(", ", winnerName);
        outputView.winner(winners);
    }
}
