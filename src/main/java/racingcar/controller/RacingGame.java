package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void start(){
        outputView.printRacingCarNameInputMessage();
        List<RacingCar> racingCars = racingCarService.save(inputView.readRacingCarName());

        outputView.printNumberOfTryInputMessage();
        int numberOfTry = inputView.readNumberOfTry();

        for(int i = 0; i < numberOfTry; i++){
            racingCarService.moveRandomly(racingCars);
            outputView.printResult(racingCars);
        }

        outputView.printWinner(racingCarService.getWinner(racingCars));

    }
}
