package racingcar.controller;

import static racingcar.controller.InputController.nameInput;
import static racingcar.controller.InputController.roundNumberInput;
import static racingcar.view.OutputView.gameResultOutputPrint;
import static racingcar.view.OutputView.gameRoundResultPrint;
import static racingcar.view.OutputView.gameWinnerPrint;

import java.util.List;
import racingcar.model.CarList;

public class GameController {
    public GameController(){
        game();
    }
    public void game(){
        List<String> nameList = nameInput();
        int roundNumber = roundNumberInput();
        CarList carList = new CarList(nameList);
        gameResultOutputPrint();
        for (int i = 0; i < roundNumber; i++) {
            carList.carListMove();
            gameRoundResultPrint(carList);
        }
        List<String> winners = carList.carListWinners();
        gameWinnerPrint(winners);
    }
}
