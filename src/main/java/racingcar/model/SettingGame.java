package racingcar.model;

public interface SettingGame extends Game {
    void saveSettings(String attributeName, Object value);
}
