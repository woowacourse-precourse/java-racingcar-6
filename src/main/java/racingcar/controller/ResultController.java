package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarService;
import racingcar.view.outputview.ResultOutputView;

import java.util.Map;

final class ResultController implements Controller {
    private final ResultOutputView resultOutputView;
    private final CarService carService;

    ResultController(ResultOutputView resultOutputView, CarService carService) {
        this.resultOutputView = resultOutputView;
        this.carService = carService;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        viewWinnersName(model);
    }

    private void viewWinnersName(Map<String, Object> model) {
        Cars winners = carService.findWinners();
        model.put("winners", winners);
        resultOutputView.display(model);
    }
}
