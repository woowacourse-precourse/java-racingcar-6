package controller;

import service.CarListService;
import service.RaceWinnerAnalyzer;
import service.Round;
import view.InputView;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

import static service.RandomMovementDecider.moveDecide;

public class RacingGame {
    private final CarListService carList;
    public RacingGame() {
        this.carList = new CarListService();
    }

    public void gameSetAndStart() {
        String carListInput = InputValidator.carListInputSetAndValidate();
        carList.init(carListInput);
        int rounds = InputValidator.roundInputSetAndValidate();

        OutputView.startPlayDisplay();
        for(int round = 0; round < rounds; round++){
            playSingleRound();
        }
        winnerSetAndDisplay();
    }

    private void playSingleRound(){
        LinkedHashMap<String, Integer> shouldMoveList = carList.getCarList();
        shouldMoveList.forEach((carName, distance) -> moveCar(carName));
        singleRoundDisplay();
    }

    private void moveCar(String carName){
        if(moveDecide()){
            carList.forwardCar(carName);
        }
    }
    private void singleRoundDisplay(){
        OutputView.displayRaceResult(carList.getCarList());
    }
    private void winnerSetAndDisplay(){
        List<String> winnerList = RaceWinnerAnalyzer.determineWinner(carList.getCarList());
        OutputView.displayWinners(winnerList);
    }

}
