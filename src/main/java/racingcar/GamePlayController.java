package racingcar;

import java.util.List;

public class GamePlayController {
    private GameSetting gameSetting;
    private UserInputHandler userInputHandler;

    public GamePlayController() {
        userInputHandler = new UserInputHandler();
    }

    private void initGameSetting() {
        String userCarInput = userInputHandler.getUserInput();
        List<Car> cars = userInputHandler.getCarsInput(userCarInput);
        String userRepeatInput = userInputHandler.getUserInput();
        int repeatNumber = userInputHandler.getRepeatNumberInput(userRepeatInput);
        gameSetting = new GameSetting(repeatNumber, cars);
    }

}
