package racingcar.domain;

public enum MovingStrategySetting {
    MOVABLE_NUMBER(4);

    private final int setting;

    MovingStrategySetting(int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
