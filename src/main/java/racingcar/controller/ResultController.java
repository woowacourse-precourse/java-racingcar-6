package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.outputview.ResultOutputView;

import java.util.Map;

import static racingcar.view.Parameter.Output.CARS;
import static racingcar.view.Parameter.Output.WINNERS;

final class ResultController implements Controller {
    private final ResultOutputView resultOutputView;

    ResultController(ResultOutputView resultOutputView) {
        this.resultOutputView = resultOutputView;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        viewWinnersName(model);
    }

    private void viewWinnersName(Map<String, Object> model) {
        if (model.get(CARS) instanceof Cars cars) {
            model.put(WINNERS, cars.getWinningCars());
            resultOutputView.display(model);
        }
    }
}
