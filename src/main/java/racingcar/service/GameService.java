package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Game;
import racingcar.view.TextInterface;

public class GameService {
    TextInterface textInterface = new TextInterface();
    Game game = new Game();

    public void init(){
        textInterface.inputAttemptsMessage();
        setAttempts(Console.readLine());
    }
    public void setAttempts(String input){
        game.createAttempts(input);
    }

    public Game getGame(){
        return game;
    }

}
