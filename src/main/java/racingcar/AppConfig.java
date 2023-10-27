package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.util.StringUtil;
import racingcar.util.TypeConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RacingController setController() {
        return new RacingController(inputView(), outputView(), racingService());
    }

    private InputView inputView() {
        return new InputView(new TypeConverter());
    }

    private OutputView outputView() {
        return new OutputView(new StringUtil());
    }

    private RacingService racingService() {
        return new RacingService();
    }

}
