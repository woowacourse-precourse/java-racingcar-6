package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRacingTrackGenerator implements RacingTrackGenerator<Car> {

    private final Map<Car, Position> map = new HashMap<>();

    @Override
    public RacingGame create(final List<Car> vehicles, final int playCount) {
        for (int index = 0; index < playCount; index++) {
            map.put(vehicles.get(index), Position.createWith(index));
        }
        return new CarRacingGame(map);
    }
}
