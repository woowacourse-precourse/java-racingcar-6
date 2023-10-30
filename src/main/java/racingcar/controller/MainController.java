package racingcar.controller;

import racingcar.domain.Cars;
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

        gameState = setGame(gameState, parameter, model);
        gameState = playGame(gameState, parameter, model);
        finishGame(gameState, parameter, model);
    }

    private GameState setGame(GameState gameState, Map<String, String> parameter, Map<String, Object> model) {
        Controller controller = adapter.get(gameState).apply(null);
        controller.run(parameter, model);
        return GameState.PLAYING;
    }

    private GameState playGame(GameState gameState, Map<String, String> parameter, Map<String, Object> model) {
        Cars cars = (Cars) model.get("cars");
        Controller controller = adapter.get(gameState).apply(cars);
        controller.run(parameter, model);
        return GameState.FINISH;
    }

    private void finishGame(GameState gameState, Map<String, String> parameter, Map<String, Object> model) {
        Cars cars = (Cars) model.get("cars");
        Controller controller = adapter.get(gameState).apply(cars);
        controller.run(parameter, model);
    }
}
