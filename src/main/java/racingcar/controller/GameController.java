package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.Game;

public class GameController {
    private Game game = new Game();

    public void setUp(String participants){
        game.setUp(Arrays.stream(participants.split(",")).map(str->str.trim()).collect(Collectors.toList()));
    }

    public void startGame(Integer numberOfAttempt){
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i<numberOfAttempt; i++){
            game.moveForwardAttemptCars();
            printCars();
        }
    }

    public void printCars(){
        game.printCars();
        System.out.println();
    }
}
