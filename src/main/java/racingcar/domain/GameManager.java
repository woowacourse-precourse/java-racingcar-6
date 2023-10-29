package racingcar.domain;

public class GameManager {
    private static GameManager gameManager = null;
    private static int carQuantity;
    private static int attemptNumber;

    private GameManager() {};

    public static GameManager create() {
        if(gameManager == null){
            gameManager = new GameManager();
        }
        return gameManager;
    }


    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }
}
