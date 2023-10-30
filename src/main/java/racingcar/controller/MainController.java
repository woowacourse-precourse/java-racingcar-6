package racingcar.controller;

import racingcar.domain.GameState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MainController {
    private final ControlConfig config;
    private final Map<GameState, Function<Object, Controller>> adapter;

    public MainController(ControlConfig config) {
        this.config = config;
        adapter = initControllerMapping();
    }

    public void run() {
        Map<String, String> parameter = new HashMap<>();
        Map<String, Object> model = new HashMap<>();
        GameState gameState = GameState.SETTING;

        startLevel(gameState, parameter, model);
    }

    private GameState startLevel(GameState gameState, Map<String, String> parameter, Map<String, Object> model) {
        Controller controller = adapter.get(gameState).apply(null);
        controller.run(parameter, model);
        return GameState.PLAYING;
    }

    private Map<GameState, Function<Object, Controller>> initControllerMapping() {
        return Map.ofEntries(
                Map.entry(GameState.SETTING, param -> config.createSettingController()),
                Map.entry(GameState.PLAYING, config::createRacingController),
                Map.entry(GameState.FINISH, config::createResultController)
        );
    }
}
