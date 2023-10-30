package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Views;
import racingcar.service.GameService;
import racingcar.domain.CarList;
import racingcar.domain.Car;

import java.util.List;

public class Controller {
    Views view = new Views();
    GameService service = new GameService();
    CarList carList = new CarList();

    public void startGame(){
        makeCars();
        makeTrialNumber();
    }

    public void makeCars(){
        view.printInputCarMessage();
        getCarNames();

    }
    public void makeTrialNumber(){
        view.printInputTrialMessage();
        getTrialNumber();
    }
    public String getCarNames(){
        String input = Console.readLine();
        return input;
    }
    public int getTrialNumber(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }



}
