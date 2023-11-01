package racingcar.view.output.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.cars.Players;

public record RacingStateDto(
    Map<String, Integer> state
) {

    public static RacingStateDto from(Players players) {
        Map<String, Integer> state = new LinkedHashMap<>();
        players.cars().forEach((car) -> state.put(
            car.name(),
            car.movement().movement()
        ));
        return new RacingStateDto(state);
    }
}
