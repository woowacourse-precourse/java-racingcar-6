package racingcar.controller.dto;

import java.util.Map;
import racingcar.model.Position;
import racingcar.model.Vehicle;

public class GameResultResponse {

    private final Map<Vehicle, Position> result;

    private GameResultResponse(final Map<Vehicle, Position> result) {
        this.result = result;
    }

    public static GameResultResponse from(final Map<Vehicle, Position> map) {
        return new GameResultResponse(map);
    }

    public Map<Vehicle, Position> getResult() {
        return result;
    }
}
