package racingcar.controller;

import static racingcar.controller.InputController.nameInput;
import static racingcar.controller.InputController.roundNumberInput;

import java.util.List;
import racingcar.model.CarList;

public class GameController {
    public GameController(){

    }
    public void gameStart(){
        List<String> nameList = nameInput();
        int roundNumber = roundNumberInput();
        CarList carList = new CarList(nameList);
    }
}
