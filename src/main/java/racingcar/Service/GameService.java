package racingcar.Service;

import java.util.Arrays;
import java.util.List;
import racingcar.Model.Game;
import racingcar.View.TextInterface;

public class GameService {
    private final TextInterface textInterface = new TextInterface();
    private Game game;

    public void initGame() {
        game = new Game(enterCar(), enterRepetition());
    }

    private List<String> enterCar() {
        String carNameString = textInterface.enterPlayer();
        return Arrays.asList(carNameString.split(","));
    }

    private int enterRepetition() {
        return Integer.parseInt(textInterface.enterRepetition());
    }

    public void startGame() {
        textInterface.printExcution();
        game.play();
    }

    public void endGame() {
        textInterface.printResult();
        game.result();
    }
}
