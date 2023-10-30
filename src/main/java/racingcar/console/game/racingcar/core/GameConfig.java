package racingcar.console.game.racingcar.core;

public class GameConfig {

    private final GameConfigConverter converter;
    private int totalRound;

    public GameConfig() {
        converter = new GameConfigConverter();
        totalRound = 0;
    }

    public void setTotalRound(String totalRound) {
        this.totalRound = converter.convertTotalRound(totalRound);
    }

    public int getTotalRound() {
        return totalRound;
    }
}
