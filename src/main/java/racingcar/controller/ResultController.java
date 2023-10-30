package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.outputview.ResultOutputView;

import java.util.Map;

public class ResultController implements Controller {
    private final ResultOutputView resultOutputView;
    private final CarService carService;

    ResultController(ResultOutputView resultOutputView, CarService carService) {
        this.resultOutputView = resultOutputView;
        this.carService = carService;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {

    }
}
