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
        outputView.printRacingCarNameInputMessage();
        List<RacingCar> racingCars = racingCarService.save(inputView.readRacingCarName());

        outputView.printNumberOfTryInputMessage();
        int numberOfTry = inputView.readNumberOfTry();

        outputView.printResult();

        for(int i = 0; i < numberOfTry; i++){
            racingCarService.moveRandomly(racingCars);
            outputView.printRacingResult(racingCars);
        }

        outputView.printWinner(racingCarService.getWinner(racingCars));

    }
}
