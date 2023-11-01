package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.outputview.PlayOutputView;

import java.util.Map;

import static racingcar.view.Parameter.GAME_COUNT;
import static racingcar.view.Parameter.Output.CARS;

final class PlayController implements Controller {
    private final PlayOutputView playOutputView;

    PlayController(PlayOutputView playOutputView) {
        this.playOutputView = playOutputView;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        if (model.get(GAME_COUNT) instanceof Integer
                && model.get(CARS) instanceof Cars) {
            playRacing(model);
        }
    }

    private void playRacing(Map<String, Object> model) {
        Cars cars = (Cars) model.get(CARS);
        int gameCount = (Integer) model.get(GAME_COUNT);


        for (int i = 0; i < gameCount; i++) {
            cars.tryMoveAllCar();
            playOutputView.display(model);
        }
    }
}
