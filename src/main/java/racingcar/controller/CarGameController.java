package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarGameController {
    private CarName carName = new CarName();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private GameRunCnt runCnt = new GameRunCnt();
    private RacingCars racingCars;
    public void startGame(){
        carName.setCarName(inputView.inputCarName());
        racingCars = new RacingCars(carName.getCarName());
        runCnt.gameRunNumber(inputView.inputGameNumber());

    }

}
