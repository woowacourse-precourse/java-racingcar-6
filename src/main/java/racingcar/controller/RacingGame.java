package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private RacingCar racingCar;
    private Integer count;


    public void start(){
        OutputView.printCarNameInputMessage();
        createRacingCar(InputView.inputCarName());


    }

    private void createRacingCar(List<String> playerCarNameList){
        racingCar = new RacingCar(playerCarNameList);
    }

    
}
