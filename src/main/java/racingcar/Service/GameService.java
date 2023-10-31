package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.Game;
import racingcar.View.TextInterface;

public class GameService {
    TextInterface textInterface = new TextInterface();
    Game game;
    public void enterCar(){
        String userInput = textInterface.enterPlayer();
        List<String> carNames = Arrays.asList(userInput.split(","));
        game = new Game(carNames);
    }

    public void enterRepetition(){
        int repetition = Integer.parseInt(textInterface.enterRepetition());
        game.setRepetition(repetition);
    }

    public void forward(){
        game.forward();
    }
}
