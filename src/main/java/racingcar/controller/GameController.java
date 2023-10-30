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
    private final Name name = new Name();
    private final Move move = new Move();
    private final Attempt attemptNum = new Attempt();
    private final OutputView outputView = new OutputView();
    HashMap<Object, String> distance = new HashMap<Object, String>();
    private int MAX_ENTRY = 0;
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        name.isValid(player);
        String attemptsNum = inputView.attemptsNum();
        attemptNum.isValid(attemptsNum);
        outputView.initial();
        for (Object playerName : player){
            this.distance.put(playerName,"");
        }
        for (int i = 0; i < Integer.parseInt(attemptsNum); i++) {
            playGame(player, this.distance);
        }
        maxDistance(this.distance);
        showWinner(this.MAX_ENTRY);
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

    public void showWinner(int maxEntry) {
        Set<Map.Entry<Object, String>> entrySet = distance.entrySet();
        List<String> winnerName = new ArrayList<>();
        for (Map.Entry<Object, String> entry : entrySet) {
            if (entry.getValue().length() == maxEntry) {
                winnerName.add((String) entry.getKey());
            }
        }
        String winners = String.join(", ", winnerName);
        outputView.winner(winners);
    }

    public void maxDistance(HashMap distance) {
        Set<Map.Entry<String, String>> entrySet = distance.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            if (entry.getValue().length() > MAX_ENTRY) {
                MAX_ENTRY = entry.getValue().length();
            }
        }
    }
}
