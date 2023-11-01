package racingcar.config;

public enum CarConfig {

    MAX_NAME_LENGTH(5),
    INIT_POSITION(0);
    private final int setting;

    CarConfig(final int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
