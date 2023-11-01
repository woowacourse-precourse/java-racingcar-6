package racingcar.controller;

import racingcar.view.Output;
import racingcar.view.Input;
import racingcar.dto.CarNameRequst;
import racingcar.dto.MoveCountRequest;

import java.util.List;

public class RacingCarGameController {
    private Input input;
    private CarController carController;
    private MoveCountRequest moveCount;
    public RacingCarGameController(){

        this.input = new Input();
        this.carController = new CarController();
    }


    public void play(){
        initConfig();
        Output.printExecutResult();

        // 라운드 진행
        for(int rount = 0; rount < moveCount.getMoveCount(); rount++){
            carController.round();
        }
        announceWinners();
    }

    private void initConfig(){
        Output.printCarNameRequest();
        initializeCars();
        Output.printReqpeatRequest();
        moveCount = input.getInputForMoveCount();
    }

    private void initializeCars(){
        List<CarNameRequst> carNames = input.getInputForNames();
        carController.initializeOperatedCars(carNames);
    }

    private void announceWinners(){
        carController.determineWinner();
    }

}
