package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.util.StringUtil;
import racingcar.util.TypeConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(inputView(), outputView(), racingService());
        racingController.run();
    }

    private static InputView inputView() {
        return new InputView(new TypeConverter());
    }

    private static OutputView outputView() {
        return new OutputView(new StringUtil());
    }

    private static RacingService racingService() {
        return new RacingService();
    }
}
