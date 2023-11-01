package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.InputCarNameSplitter;
import racingcar.service.RaceResultGenerator;
import racingcar.service.RacingInitService;
import racingcar.service.RacingService;

public class RacingFactory {
    public RacingController createRacingController() {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        RaceResultGenerator generator = new RaceResultGenerator();
        RacingService racingService = new RacingService(generator);
        RacingInitService racingInitService = new RacingInitService(splitter);

        return new RacingController(racingService, racingInitService);
    }
}
