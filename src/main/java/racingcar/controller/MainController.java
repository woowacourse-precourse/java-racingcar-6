package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static racingcar.controller.ControlConfig.createSettingController;
import static racingcar.view.Parameter.Output.CARS;

public final class MainController {
    private final Map<GameState, Function<Object, Controller>> adapter;
    private final Map<String, String> parameter = new HashMap<>();
    private final Map<String, Object> model = new HashMap<>();

    public MainController() {
        adapter = initControllerMapping();
    }

    public void run() {
        GameState gameState = GameState.SETTING;

        gameState = setGame(gameState);
        gameState = playGame(gameState);
        finishGame(gameState);
    }

    private static Map<GameState, Function<Object, Controller>> initControllerMapping() {
        return Map.ofEntries(
                Map.entry(GameState.SETTING, param -> createSettingController()),
                Map.entry(GameState.PLAYING, ControlConfig::createPlayController),
                Map.entry(GameState.FINISH, ControlConfig::createResultController)
        );
    }

    private GameState setGame(GameState gameState) {
        runMappedController(gameState, null);
        return GameState.PLAYING;
    }

    private GameState playGame(GameState gameState) {
        Cars cars = (Cars) model.get(CARS);
        runMappedController(gameState, cars);
        return GameState.FINISH;
    }

    private void finishGame(GameState gameState) {
        Cars cars = (Cars) model.get(CARS);
        runMappedController(gameState, cars);
    }

    private void runMappedController(GameState gameState, Cars cars) {
        Controller controller = adapter.get(gameState).apply(cars);
        controller.run(parameter, model);
    }
}
