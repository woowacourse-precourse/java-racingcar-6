package racingcar.display.graphics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.entity.Car;

public class RacingCarDistanceGraphics {
    private static final char DISTANCE_GRAPHIC_CHARACTER = '-';
    private static final String DISTANCE_GRAPHIC_STRING = "-";
    private static final String EMPTY_STRING = "";

    private static final Map<String, String> store = new HashMap<>();

    public RacingCarDistanceGraphics(List<Car> cars) {
        init(cars);
    }

    private void init(List<Car> cars) {
        cars.forEach(car -> store.put(car.getCarName(), EMPTY_STRING));
    }

    public Map<String, String> updateCarGraphicsBasedOnDistance(List<Car> cars) {
        for (Car car : cars) {
            String distanceGraphic = store.get(car.getCarName());
            int distanceCount = getDistanceCount(distanceGraphic);

            if (car.getDistance() > distanceCount) {
                store.put(car.getCarName(), generateCarDistanceGraphic(car.getDistance()));
            }
        }

        return store;
    }

    private int getDistanceCount(String distanceGraphic) {
        return (int) distanceGraphic.chars()
                .filter(ch -> ch == DISTANCE_GRAPHIC_CHARACTER)
                .count();
    }

    private String generateCarDistanceGraphic(int distanceCount) {
        return DISTANCE_GRAPHIC_STRING.repeat(distanceCount);
    }
}
