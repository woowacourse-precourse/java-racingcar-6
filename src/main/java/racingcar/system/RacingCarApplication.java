package racingcar.system;

import java.util.HashMap;
import java.util.Map;
import racingcar.controller.Controller;
import racingcar.controller.DisplayRoundController;
import racingcar.controller.RacingResultController;
import racingcar.controller.RegisterCarNamesController;
import racingcar.controller.RegisterRoundController;
import racingcar.view.inputview.RegisterCarNamesInputView;
import racingcar.view.inputview.RegisterRoundInputView;
import racingcar.view.outputview.DisplayRoundOutputView;
import racingcar.view.outputview.RacingResultOutputView;
import racingcar.view.outputview.RegisterCarNamesOutputView;
import racingcar.view.outputview.RegisterRoundOutputView;

public class RacingCarApplication {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public RacingCarApplication() {
        controllerMap.put("registerCars", new RegisterCarNamesController(
                new RegisterCarNamesOutputView(),
                new RegisterCarNamesInputView()
        ));
        controllerMap.put("registerRound", new RegisterRoundController(
                new RegisterRoundOutputView(),
                new RegisterRoundInputView()
        ));
        controllerMap.put("displayRound", new DisplayRoundController(
                new DisplayRoundOutputView()
        ));
        controllerMap.put("racingResult", new RacingResultController(
                new RacingResultOutputView()
        ));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        registerCarNames(model);
        registerRound(model);
        displayStatus(model);
        displayWinnerNames(model);
    }

    private void displayWinnerNames(Map<String, Object> model) {
        controllerMap.get("racingResult").process(model);
    }

    private void displayStatus(Map<String, Object> model) {
        controllerMap.get("displayRound").process(model);
    }

    private void registerRound(Map<String, Object> model) {
        controllerMap.get("registerRound").process(model);
    }

    private void registerCarNames(Map<String, Object> model) {
        controllerMap.get("registerCars").process(model);
    }
}
