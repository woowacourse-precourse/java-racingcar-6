package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingGame(){
        inputView = new InputView();
        outputView = new OutputView();
        racingCarService = new RacingCarService(new RandomNumberGenerator());
    }

    public void start(){
        List<RacingCar> racingCars = getRacingCars();
        int numberOfTry = getNumberOfTry();

        printRacingResult(numberOfTry, racingCars);
        printRaceWinner(racingCars);
    }

    private List<RacingCar> getRacingCars(){
        outputView.printRacingCarNameInputMessage();

        return racingCarService.save(inputView.readRacingCarName());
    }

    private int getNumberOfTry(){
        outputView.printNumberOfTryInputMessage();

        return inputView.readNumberOfTry();
    }

    private void printRacingResult(int numberOfTry, List<RacingCar> racingCars){
        outputView.printResult();

        for(int i = 0; i < numberOfTry; i++){
            racingCarService.moveRandomly(racingCars);
            outputView.printRacingResult(racingCars);
        }
    }

    private void printRaceWinner(List<RacingCar> racingCars){
        outputView.printWinner(racingCarService.getWinner(racingCars));
    }
}
