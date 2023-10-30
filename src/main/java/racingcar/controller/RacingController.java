package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.outputview.RacingOutputView;

import java.util.Map;

public class RacingController implements Controller {
    private final RacingOutputView racingOutputView;
    private final CarService carService;

    RacingController(RacingOutputView racingOutputView, CarService carService) {
        this.racingOutputView = racingOutputView;
        this.carService = carService;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {

    }
}
