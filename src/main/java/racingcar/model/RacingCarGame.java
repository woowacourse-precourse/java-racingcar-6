package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame implements SettingGame {
    private final Map<String, Object> settings = new HashMap<>();

    @Override
    public void saveSettings(String attribute, Object value) {
        settings.put(attribute, value);
    }
}
