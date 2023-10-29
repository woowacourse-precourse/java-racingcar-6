package racingcar.controller;

import racingcar.model.Game;
import racingcar.model.Move;
import racingcar.model.Name;
import racingcar.view.InputView;

import java.util.*;

public class GameController {
    private final InputView inputView = new InputView();
    private final Name name = new Name();
    private final Move move = new Move();
    HashMap<Object, String> distance = new HashMap<Object, String>();
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        name.isValid(player);
        int attemptsNum = Integer.parseInt(inputView.attemptsNum());
        for (Object playerName : player){
            distance.put(playerName,"");
        }
        for (int i = 0; i < attemptsNum; i++) {
            playGame(player, distance);
        }
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
    }
}
