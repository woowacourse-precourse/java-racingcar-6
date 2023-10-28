package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.Game;

public class GameController {
    private Game game = new Game();

    public void setUp(String participants){
        game.setUp(Arrays.stream(participants.split(",")).collect(Collectors.toList()));
    }

    public void printCars(){
        game.printCars();
    }
}
