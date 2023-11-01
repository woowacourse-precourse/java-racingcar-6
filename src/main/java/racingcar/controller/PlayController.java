package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.outputview.PlayOutputView;

import java.util.Map;

import static racingcar.view.Parameter.GAME_COUNT;

final class PlayController implements Controller {
    private final PlayOutputView playOutputView;
    private final CarService carService;

    PlayController(PlayOutputView playOutputView, CarService carService) {
        this.playOutputView = playOutputView;
        this.carService = carService;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        if (model.get(GAME_COUNT) instanceof Integer) {
            playRacing(model);
        }
    }

    private void playRacing(Map<String, Object> model) {
        int gameCount = (Integer) model.get(GAME_COUNT);

        for (int i = 0; i < gameCount; i++) {
            carService.moveAllCarByRandom();
            playOutputView.display(model);
        }
    }
}
