package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;

public class GameController {

    private int tryCount;
    private HashMap<String,Integer> carStates = new HashMap<>();
    private Cars cars;

    public GameController(){
        gameSet();
        gamePlay();
    }

    public void gameSet(){
        cars = new Cars(InputView.getCarName());
        tryCount = GameUtil.setTryCount(InputView.getRound());
    }

    public void gamePlay(){
        OutputView.playMessage();
        for(int i=0; i<tryCount; i++) {
            cars.move();
            getCarStates();
        }
    }

    public void getCarStates(){
        carStates = cars.carStates();
        OutputView.carsStateShow(carStates);
    }
}
