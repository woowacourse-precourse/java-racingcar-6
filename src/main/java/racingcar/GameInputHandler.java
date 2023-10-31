package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.business.GameManager;
import racingcar.business.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class GameInputHandler {
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public void startGame() {
        //자동차 이름 입력 메시지 출력
        consoleOutput.printCarNameInput();
        String carsString = getUserInput();
        List<String> cars = splitAndConvertToList(carsString);
        //자동차 이름 예외 체크
        checkForExceptionCarsName(carsString);
        //시도할 횟수 입력 메시지 출력
        consoleOutput.printAttemptsInput();
        String attempts = getUserInput();
        //시도할 횟수 예외 체크
        checkForExceptionAttempts(attempts);
        GameManager gameManager = new GameManager(cars, Integer.parseInt(attempts));
        //게임 진행!
        gameManager.game();
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private List<String> splitAndConvertToList(String carsString) {
        List<String> carList = new ArrayList<>();
        String[] cars = carsString.split(",");
        for (String car : cars) {
            carList.add(car);
        }
        return carList;
    }

    private void checkForExceptionCarsName(String carsString) {
        InputValidator inputValidator = new InputValidator();
        List<String> cars = splitAndConvertToList(carsString);
        inputValidator.validateCarsName(cars);
        inputValidator.validateInputValue(carsString);
    }

    private void checkForExceptionAttempts(String attempts) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateInputValue(attempts);
        inputValidator.validateAttempts(attempts);
    }
}
