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
    private static final String REGISTER_CARS_PATH = "registerCars";
    private static final String REGISTER_ROUND_PATH = "registerRound";
    private static final String DISPLAY_ROUND_PATH = "displayRound";
    private static final String RACING_RESULT_PATH = "racingResult";
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public RacingCarApplication() {
        controllerMap.put(REGISTER_CARS_PATH, new RegisterCarNamesController(
                new RegisterCarNamesOutputView(),
                new RegisterCarNamesInputView()
        ));
        controllerMap.put(REGISTER_ROUND_PATH, new RegisterRoundController(
                new RegisterRoundOutputView(),
                new RegisterRoundInputView()
        ));
        controllerMap.put(DISPLAY_ROUND_PATH, new DisplayRoundController(
                new DisplayRoundOutputView()
        ));
        controllerMap.put(RACING_RESULT_PATH, new RacingResultController(
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
        controllerMap.get(RACING_RESULT_PATH).process(model);
    }

    private void displayStatus(Map<String, Object> model) {
        controllerMap.get(DISPLAY_ROUND_PATH).process(model);
    }

    private void registerRound(Map<String, Object> model) {
        controllerMap.get(REGISTER_ROUND_PATH).process(model);
    }

    private void registerCarNames(Map<String, Object> model) {
        controllerMap.get(REGISTER_CARS_PATH).process(model);
    }
}
