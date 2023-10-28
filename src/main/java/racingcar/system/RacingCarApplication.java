package racingcar.system;

import java.util.HashMap;
import java.util.Map;
import racingcar.controller.Controller;
import racingcar.controller.RegisterCarNamesController;
import racingcar.view.inputview.RegisterCarNamesInputView;
import racingcar.view.outputview.RegisterCarNamesOutputView;

public class RacingCarApplication {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public RacingCarApplication() {
        controllerMap.put("register", new RegisterCarNamesController(
                new RegisterCarNamesOutputView(),
                new RegisterCarNamesInputView()
        ));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        registerCarNames(model);
    }

    private void registerCarNames(Map<String, Object> model) {
        controllerMap.get("register").process(model);
    }
}
