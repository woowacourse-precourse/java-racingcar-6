package racingcar.controller;

import static racingcar.view.GameView.inputCarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game model;
    private GameView view;
    public GameController(Game model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        String input = inputCarName();
        List<String> carNames = splitCarNames(input);
        System.out.println(carNames);
    }

    private List<String> splitCarNames(String input){
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

}
