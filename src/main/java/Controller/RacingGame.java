package Controller;

import Model.RacingCar;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    InputView inputView = new InputView();
    OutputView outputView =  new OutputView();
    List<RacingCar> racingCars = new ArrayList<>();
    int trial = 0;

    public void gameInit(){
        gameStart();
        gameSet();
        gameRound();
        gameFinish();
    }

    public void gameStart(){
        racingCars.clear();
    }

    public void gameSet(){
        outputView.printStart();
        racingCars = inputView.getNames();
        outputView.printTrial();
        trial = inputView.getTrial();
    }

    public void gameRound(){
        outputView.printResultMessage();
        for (int round = 0; round < trial; round++){
            for (RacingCar racingCar : racingCars){
                racingCar.forward();
            }
            outputView.printResult(racingCars);
        }
    }

    public void gameFinish(){
        outputView.printWinner(findWinner());
    }

    public List<String> findWinner(){
        final RacingCar maxDistanceRacingCar = findMaxDistanceRacingCar();
        return findSameDistanceRacingCar(maxDistanceRacingCar);
    }

    public RacingCar findMaxDistanceRacingCar(){
        return racingCars.stream().max(RacingCar::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    public List<String> findSameDistanceRacingCar(RacingCar maxDistanceRacingCar){
        return racingCars.stream().filter(maxDistanceRacingCar::isSameDistance).map(RacingCar::getName).collect(Collectors.toList());
    }
}
