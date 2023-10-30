package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;

public class GameController {

    private int repeatNum;
    private HashMap<String,Integer> carStates = new HashMap<>();
    private Cars cars;

    public GameController(){
        gameSet();
        gamePlay();
        gameResult();
    }

    public void gameSet(){
        cars = new Cars(InputView.getCarName());
        repeatNum = GameUtil.setRepeatCount(InputView.getRound());
    }

    public void gamePlay(){
        OutputView.playMessage();
        for(int i = 0; i< repeatNum; i++) {
            cars.move();
            getCarStates();
        }
    }

    public void gameResult(){
        OutputView.resultMessage(cars.getWinners());
    }

    public void getCarStates(){
        carStates = cars.carsStates();
        OutputView.carsStateShow(carStates);
    }
}
