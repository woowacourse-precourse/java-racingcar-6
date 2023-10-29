package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    GameManager gameManager = new GameManager();
    GameElements gameElements = GameElements.INSTANCE;

    public void startGame() {
        gameManager.gameSetting();
        gamingWithTryCount();
        checkWinner();
    }

    private void gamingWithTryCount() {
        int totalTryCount = gameElements.getTryCount();

        for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
            runGameForCar();
        }
    }

    private void runGameForCar() {
        for (String car : gameElements.getCarNameList()) {
            checkMoveForward(car);
        }
    }

    private void checkMoveForward(String car) {
        if (gameManager.createRandomNumber() >= 4) {
            int forwardCount = gameElements.getCarMap().get(car) + 1;
            gameElements.getCarMap().replace(car, forwardCount);
        }
    }

    private List<String> checkWinner(){
        int max = -1;
        List<String> winnerList = new ArrayList<>();

        for(String car : gameElements.getCarNameList()){
            if(max <= gameElements.getCarMap().get(car)){
                max = gameElements.getCarMap().get(car);
                winnerList.add(car);
            }
        }
        return winnerList;
    }
}
