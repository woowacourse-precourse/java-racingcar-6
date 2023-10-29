package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RaceController raceController(){
        return new RaceController(race(), inputView(), outputView());
    }

    public Race race() {
        return new Race(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }
}
