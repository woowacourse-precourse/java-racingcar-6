package racingcar.controller.dto;

import java.util.Map;

public class GameResultResponse {

    private final Map<String , Integer> result;

    private GameResultResponse(final Map<String, Integer> result) {
        this.result = result;
    }

    public static GameResultResponse from(final Map<String , Integer> map) {
        return new GameResultResponse(map);
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
