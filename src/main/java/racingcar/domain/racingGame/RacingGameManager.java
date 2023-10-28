package racingcar.domain.racingGame;

public class RacingGameManager {
    private final RacingGameSettingsManager racingGameSettingsManager;
    private final RacingGame racingGame;

    public RacingGameManager(RacingGameSettingsManager racingGameSettingsManager, RacingGame racingGame) {
        this.racingGameSettingsManager = racingGameSettingsManager;
        this.racingGame = racingGame;
    }

    public void start() {
        racingGameSettingsManager.setting();
        racingGame.play();
    }
}
