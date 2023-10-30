package racingcar.domain;

public enum GameRoundSetting {

    MIN_TOTAL_GAME_ROUND_COUNT(1),
    INIT_CURRENT_GAME_ROUND_COUNT(0);


    private final int setting;

    GameRoundSetting(int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
