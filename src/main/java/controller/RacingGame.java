package controller;

import service.CarListService;
import service.Round;
import view.InputView;
import view.OutputView;

import java.util.Map;

import static service.RandomMovementDecider.moveDecide;

public class RacingGame {
    private final CarListService carList;
    public RacingGame() {
        this.carList = new CarListService();
    }

    public void gameSetAndStart() {
        carList.init(InputView.setCarNames());
        Integer rounds = Round.setRound();

        for(int round = 0; round < rounds; round++){
            playSingleRound();
            singleRoundDisplay();
        }
    }

    private void playSingleRound(){
        Map<String, Integer> shouldMoveList   = carList.getCarList();
        shouldMoveList.forEach((carName, distance) -> moveCar(carName));
    }

    private void moveCar(String carName){
        if(moveDecide(carName)){
            carList.forwardCar(carName);
        }
    }
    private void singleRoundDisplay(){
        OutputView.displayRaceResult(carList.getCarList());
    }

}
