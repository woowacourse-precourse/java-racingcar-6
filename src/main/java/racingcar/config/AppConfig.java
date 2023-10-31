package racingcar.config;

import racingcar.model.Model;
import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.RaceView;
import racingcar.domain.RandomNumberGenerator;

public class AppConfig {

    public static RaceController steup() {

        Model model = new Model();
        RaceView raceView = new RaceView(model);

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RaceService raceService = new RaceService(randomNumberGenerator);

        return new RaceController(
                raceService,
                raceView,
                model
        );
    }

}
