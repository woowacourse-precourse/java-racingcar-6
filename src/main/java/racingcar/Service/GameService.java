package racingcar.Service;

import java.util.Arrays;
import java.util.List;
import racingcar.Model.Game;
import racingcar.View.TextInterface;

public class GameService {
    TextInterface textInterface = new TextInterface();
    Game game;

    public void enterInput() {
        game = new Game(enterCar(), enterRepetition());
    }

    private List<String> enterCar() {
        String userInput = textInterface.enterPlayer();
        return Arrays.asList(userInput.split(","));
    }

    private int enterRepetition() {
        return Integer.parseInt(textInterface.enterRepetition());
    }


    public void forward() {
        game.forward();
    }

    public void result() {
        game.result();
    }
}
