package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.GameUtil;
import racingcar.view.OutputView;

public class GameController {

    private int tryCount;
    private Cars cars;

    public GameController(){
        gameSet();
        System.out.println("");
        OutputView.playMessage();
        for(int i=0; i<tryCount; i++) {
            cars.move();
            cars.carsState();
            System.out.println("");
        }
    }

    public void gameSet(){
        cars = new Cars();
        tryCount = GameUtil.setTryCount();
    }
}
