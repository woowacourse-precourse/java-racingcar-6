package racingcar;

import java.util.List;

public class GamePlayController {
    private GameSetting gameSetting;
    private UserInputHandler userInputHandler;
    private Judge judge;
    private OutputHandler outputHandler;

    public GamePlayController() {
        userInputHandler = new UserInputHandler();
        judge = new Judge();
        outputHandler = new OutputHandler();
    }

    public void gameStart() {
        initGameSetting();
        playAllGame();
        endGame();
    }

    private void initGameSetting() {
        String userCarInput = userInputHandler.getUserInput();
        List<Car> cars = userInputHandler.getCarsInput(userCarInput);
        String userRepeatInput = userInputHandler.getUserInput();
        int repeatNumber = userInputHandler.getRepeatNumberInput(userRepeatInput);
        gameSetting = new GameSetting(repeatNumber, cars);
    }

    private void playAllGame() {
        for (int i = 0; i < gameSetting.getRepeatNumber(); i++) {
            playSubGame();
        }
    }

    private void playSubGame() {
        List<Car> cars = gameSetting.getCars();
        for (Car car : cars) {
            car.move(judge);
            outputHandler.printSubResult(car);
        }
    }

    private void endGame() {
        List<String> finalWinners = judge.getFinalWinner(gameSetting.getCars());
        outputHandler.printFinalResult(finalWinners);
    }
}
