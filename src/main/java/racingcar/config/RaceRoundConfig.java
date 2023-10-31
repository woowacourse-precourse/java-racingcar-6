package racingcar.config;

public enum RaceRoundConfig {

    MIN_TOTAL_GAME_ROUND_COUNT(1),
    INIT_CURRENT_GAME_ROUND_COUNT(0);

    private final int setting;

    RaceRoundConfig(final int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
