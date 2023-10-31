package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.Output;

public class Game {
    GameManager gameManager = new GameManager();

    public void startGame() {
        gamingWithTryCount();
        Output.printGameWinnerMessage(String.join(", ", checkWinner()));
    }

    private void gamingWithTryCount() {
        List<Car> carList = gameManager.carSetting();
        int totalTryCount = gameManager.tryCountSetting();

        Output.printResultMessage();

        for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
            runGameForCar(carList);
            Output.printGameProgress(carList);
        }
    }

    private void runGameForCar(List<Car> carList) {
        for(Car car : carList){
            car.move();
        }
    }

    private List<String> checkWinner() {
        List<String> winnerList = new ArrayList<>();

        for (String car : gameElements.getCarNameList()) {
            if (findMaxForwardCount() == gameElements.getCarMap().get(car)) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }

    private int findMaxForwardCount() {
        int max = -1;

        for (String car : gameElements.getCarNameList()) {
            if (max <= gameElements.getCarMap().get(car)) {
                max = gameElements.getCarMap().get(car);
            }
        }

        return max;
    }
}
