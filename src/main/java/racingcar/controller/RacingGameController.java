package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.service.CarService;
import racingcar.service.TryService;

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

    }

    private void race(RacingCars racingCars, TryCount tryCount) {
        for(int i=0; i<tryCount.getTryCount(); i++){
            racingCars.moveCars();
        }
    }


}
