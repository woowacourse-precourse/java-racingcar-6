package racingcar.domain.dto;

public class GameResult {
    private String carName;
    private int carDistances;

    private GameResult() {}

    public static GameResult createGameResult(String carName, int carDistances) {
        GameResult gameResult = new GameResult();
        gameResult.carName = carName;
        gameResult.carDistances = carDistances;

        return gameResult;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarDistances() {
        return carDistances;
    }
}
