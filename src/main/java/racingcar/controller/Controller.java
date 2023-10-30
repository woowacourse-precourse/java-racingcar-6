package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Views;
import racingcar.service.GameService;
import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.List;

public class Controller {
    Views view = new Views();
    GameService service = new GameService();
    Cars cars = new Cars();

    public void startGame(){
        makeCars();
        makeTrialNumber();
    }

    public void makeCars(){
        view.printInputCarMessage();
        makeCarList(service.splitCarNames(getCarNames()));

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
    public void makeCarList(List<String> input){
        for(String name : input){
            cars.saveCars(new Car(name));
        }
    }


}
