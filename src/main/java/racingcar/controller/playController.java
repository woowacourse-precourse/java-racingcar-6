package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.outputview.PlayOutputView;

import java.util.Map;

public class playController implements Controller {
    private final PlayOutputView playOutputView;
    private final CarService carService;

    RacingController(RacingOutputView racingOutputView, CarService carService) {
        this.racingOutputView = racingOutputView;
        this.carService = carService;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {

    }
}
