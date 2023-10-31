package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.service.CarService;
import racingcar.service.TryService;
import racingcar.view.OutputView;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class RacingGameController {


    private final CarService carService;
    private final TryService tryService;

    private RacingCars racingCars;

    private TryCount tryCount;

    public RacingGameController(){
        carService = new CarService();
        tryService = new TryService();
    }
    public void start(){
        racingCars = carService.getCarNames();
        tryCount = tryService.getTryCount();
        race(racingCars, tryCount);
        printWinner(findWinner(racingCars));

    }

    private void printWinner(Winner winner) {
        OutputView.printWinnerMessage(winner);
    }

    private Winner findWinner(RacingCars racingCars) {
        return racingCars.findWinner();
    }

    private void race(RacingCars racingCars, TryCount tryCount) {
        for(int i=0; i<tryCount.getTryCount(); i++){
            racingCars.moveCars();
        }
    }


}
