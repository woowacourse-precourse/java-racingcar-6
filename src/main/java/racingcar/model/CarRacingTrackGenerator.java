package racingcar.model;

import static racingcar.util.Constant.ONE_INDEX;
import static racingcar.util.Constant.ZERO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CarRacingTrackGenerator implements RacingTrackGenerator<Car> {

    @Override
    public RacingGame create(final List<Car> vehicles, final int playCount) {
        Map<Car, Position> map = new LinkedHashMap<>();
        Position initPosition = Position.createWith(ZERO.getValue());
        createPosition(playCount);

        for (Car car : vehicles) {
            map.put(car, initPosition);
        }
        return CarRacingGame.createWith(new CarRacingManager(map));
    }

    private void createPosition(final int playCount) {
        IntStream.rangeClosed(ONE_INDEX.getValue(), playCount)
                .forEach(Position::createWith);
    }
}
