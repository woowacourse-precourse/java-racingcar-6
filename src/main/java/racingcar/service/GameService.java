package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.TextInterface;

import java.util.List;

public class GameService {
    TextInterface textInterface = new TextInterface();
    Game game = new Game();

    public int enterAttempts(){
        textInterface.inputAttemptsMessage();
        return setAttempts(Console.readLine());
    }
    public int setAttempts(String input){
        game.createAttempts(input);
        return game.getAttempts();
    }

    public Game getGame(){
        return game;
    }

    public void racing(List<Car> cars){

    }

    public void printResult(List<Car> cars){

    }

}
