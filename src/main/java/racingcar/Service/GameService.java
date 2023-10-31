package racingcar.Service;

import racingcar.Model.Game;
import racingcar.View.TextInterface;

public class GameService {
    TextInterface textInterface = new TextInterface();

    public void set(){
        int repetition = Integer.parseInt(textInterface.enterRepetition());
        Game game = new Game(repetition);
    }
}
