package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {

    private final GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        this.gameView = new GameView();
        this.gameModel = new GameModel();
    }

    public void insertCarToCarArray(String[] carNamesArray) {
        gameModel.insertCarToCarArray(carNamesArray);
    }

    public void askHowManyTimes() {
        gameView.printMessage(GameModel.HOW_MANY_TIMES_MESSAGE);
    }


    public int findMaxPosition() {
        return gameModel.findMaxPosition();
    }

    public void carPrepare() {
        printStartMessage();
        String[] carNamesArray = Console.readLine().split(",");
        checkNameLength(carNamesArray);
        insertCarToCarArray(carNamesArray);
    }

    private void checkNameLength(String[] carNamesArray) {
        for(String carName: carNamesArray) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }


    public void displayGameResult(String RESULT_MESSAGE, Map<String, Integer> carData) {
        gameView.displayGameResult(RESULT_MESSAGE, carData);
    }

    public void playingGame() {
        askHowManyTimes();
        int count = Integer.parseInt(Console.readLine());
        gameModel.saveResult(count);
    }

    public void findWinner(Map<String, Integer> carData) {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        carData.forEach((name, position) -> {
            if (position == maxPosition) {
                winners.add(name);
            }
        });
        gameView.printWinner(GameModel.WINNER_MESSAGE, winners);
    }
    public void run() {

        carPrepare();
        playingGame();
        displayGameResult(GameModel.RESULT_MESSAGE, gameModel.getCarData());
        findWinner(gameModel.getCarData());
    }

    public void printStartMessage() {
        gameView.printMessage(GameModel.START_MESSAGE);
    }
}
