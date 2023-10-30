package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame implements SettingGame {
    private static final int criterion = 4;
    private final Map<String, Object> settings = new HashMap<>();

    @Override
    public void saveSettings(String attribute, Object value) {
        settings.put(attribute, value);
    }

    public void goAhead(Car car, int randomNumber) {
        if (randomNumber >= criterion) {
            car.move();
        }
    }
}
