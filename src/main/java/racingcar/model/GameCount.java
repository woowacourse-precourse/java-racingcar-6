package racingcar.model;

public class GameCount {
    private static int gameCount = 0;
    private static int highStep = 0;
    Cars cars = new Cars();

    public int setGameCount(int number) {
        GameCount.gameCount = number;
        return GameCount.gameCount;
    }

    public int getGameCount() {
        return GameCount.gameCount;
    }

    public void setHighStep() {
        for (int i = GameCount.gameCount; i >= 0; i--) {
            if (cars.getCarsData().containsValue(i)) {
                GameCount.highStep = i;
                break;
            }
        }
    }

    public int getHighStep() {
        return GameCount.highStep;
    }
}
