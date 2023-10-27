package racingcar.model;

import static racingcar.util.Constant.ZERO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CarRacingTrackGenerator implements RacingTrackGenerator<Car> {

    private static final int ONE = 1;

    private final Map<Car, Position> map = new HashMap<>();

    @Override
    public RacingGame create(final List<Car> vehicles, final int playCount) {
        Position initPosition = Position.createWith(ZERO.getValue());
        for (Car car : vehicles) {
            map.put(car, initPosition);
        }
        createPosition(playCount);
        return new CarRacingGame(map);
    }

    private void createPosition(final int playCount) {
        IntStream.rangeClosed(ONE, playCount)
              .forEach(Position::createWith);
    }
}
