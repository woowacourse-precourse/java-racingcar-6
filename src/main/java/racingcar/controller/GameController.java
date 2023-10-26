package racingcar.controller;
import racingcar.validator.InputValidation;
import racingcar.view.*;

public class GameController {
    OutputView getMessage = new OutputView();
    InputView putMessage = new InputView();
    GameUtils gameUtility = new GameUtils();
    InputValidation validator = new InputValidation();
    public void run(){
        getMessage.GameStartMessage();
        String namesOfRacingCars = putMessage.getPlayerInput();
        if(validator.checkPlayerInput(namesOfRacingCars)){
            gameUtility.splitByComma();
        }else{
            throw new IllegalArgumentException();
        }
    }
}
