package racingcar;

public class Game {
    GameManager gameManager = new GameManager();
    GameElements gameElements = new GameElements();

    public void startGame() {
        gameManager.gameSetting();
    }
    
    private void checkMoveForward(String car) {
        if (gameManager.createRandomNumber() >= 4) {
            int forwardCount = gameElements.getCarMap().get(car) + 1;
            gameElements.getCarMap().replace(car, forwardCount);
        }
    }
}
