package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.GameUtil;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private int tryCount;
    private Cars cars;

    public GameController(){
        gameSet();
    }

    public void gameSet(){
        cars = new Cars();
        tryCount = GameUtil.setTryCount();
    }
}
