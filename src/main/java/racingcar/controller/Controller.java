package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Views;
import racingcar.service.gameService;

import java.util.List;

public class Controller {
    Views view = new Views();
    gameService service = new gameService();
    public void startGame(){
        makeCars();
    }

    public void makeCars(){
        view.printInputCarMessage();
        List<String> carNames = service.splitCarNames(getCarNames());
    }

    public String getCarNames(){
        String input = Console.readLine();
        return input;
    }
}
