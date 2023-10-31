package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.OutputView;
import java.util.stream.IntStream;

public class GameController {
    InputController inputController;
    Race race;

    public GameController() {
        setInputController();
        setRace();
        play();
        printWinner();
    }

    public void setInputController(){
        inputController = new InputController();
    }
    public void setRace(){
        race = new Race(inputController.carValidate(), inputController.roundValidate());
    }
    public void play(){
        IntStream.range(0, race.getRound())
                .forEach(i -> OutputView.printRace(race.start()));
    }
    public void printWinner(){
        OutputView.printWinner(race.getWinner());
    }
}
