package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.RaceRule;
import racingcar.domain.RaceRuleImpl;
import racingcar.service.RacingService;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Configuration {

    public static RacingService racingService() {

        RaceRule raceRule = new RaceRuleImpl();

        return new RacingService(raceRule);
    }

    public static RacingController racingController() {
        return new RacingController(racingService(),
                new InputView(),
                new OutputView());
    }
}
