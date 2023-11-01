package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class GameController {

    private final GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        this.gameView = new GameView();
        this.gameModel = new GameModel();
    }

    private void insertCarToCarArray(String[] carNamesArray) {
        gameModel.insertCarToCarArray(carNamesArray);
    }

    private void askHowManyTimes() {
        gameView.printMessage(GameModel.HOW_MANY_TIMES_MESSAGE);
    }


    private int findMaxPosition() {
        return gameModel.findMaxPosition();
    }

    private void carPrepare() {
        gameView.printMessage(GameModel.START_MESSAGE);
        String[] carNamesArray = Console.readLine().split(",");
        checkNameValidity(carNamesArray);
        insertCarToCarArray(carNamesArray);
    }

    private void checkNameValidity(String[] carNamesArray) {
        List<String> namesList = Arrays.asList(carNamesArray);

        for(String carName: carNamesArray) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("[Error]: Name length should be 5 or less.");
            }
            if(carName.contains("-")) {
                throw new IllegalArgumentException("[Error]: Invalid characters in name.");
            }
        }

        if(namesList.size() != new HashSet<>(namesList).size()) {
            throw new IllegalArgumentException("[Error]: Duplicate names are not allowed.");
        }
    }



    private void displayGameResult(Map<String, Integer> carData) {
        gameView.displayGameResult(GameModel.RESULT_MESSAGE, carData);
    }

    private void playingGame() {
        askHowManyTimes();
        int count = Integer.parseInt(Console.readLine());
        gameModel.saveResult(count);
    }

    private void findWinner(Map<String, Integer> carData) {
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
        displayGameResult(gameModel.getCarData());
        findWinner(gameModel.getCarData());
    }

}
