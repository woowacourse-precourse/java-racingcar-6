package racingcar.Controller;

import racingcar.ConstantAndGameLogic.GameLogic;
import racingcar.View.Output;
import racingcar.View.User_Input;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GameLogic gameLogic;
    private final User_Input user_input;
    private final Output output;

    public GameController(){
        gameLogic = new GameLogic();
        user_input = new User_Input();
        output = new Output();
    }
    public void gamestart(){
        registerCars();
        registerMovingNumber();
        racingStart();
        raceOver();

    }
    private void registerCars(){
        output.inputName();
        List<String> inputCars = user_input.InputName();
        gameLogic.registerCarName(inputCars);
    }

    private void registerMovingNumber(){
        output.inputNumber();
        int moveCounts = user_input.UserCountInput();
        gameLogic.registerMovingNumber(moveCounts);
    }

    private void racingStart(){
        output.printRaceStart();
        while (!gameLogic.checkIsOver()){
            gameLogic.racingStart();
            output.printCars(gameLogic.getCars());
        }
    }

    private void raceOver(){
        output.printWinners(gameLogic.selectWinners());
    }
}