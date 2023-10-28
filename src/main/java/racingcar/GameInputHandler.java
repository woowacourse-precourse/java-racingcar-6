package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameInputHandler {
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public void startGame(){
        consoleOutput.printInputCarName();
        String carsString = userInput();
        List<String> cars = splitStringToList(carsString);
        //자동차 이름 예외 체크
        checkForException(carsString);
        consoleOutput.printInputAttempts();
        String attempts = userInput();
        //시도할 횟수 예외 체크
        checkForExceptionAttempts(attempts);
        GameManager gameManager = new GameManager(cars, Integer.parseInt(attempts));
        //게임 진행!
        gameManager.game();
    }
    private String userInput(){
        String userData = Console.readLine();
        return userData;
    }

    public List<String> splitStringToList(String carsString){
        List<String> carList = new ArrayList<>();
        String[] cars = carsString.split(",");
        for(String car: cars){
            carList.add(car);
        }
        return carList;
    }

    private void checkForException(String carsString){
        InputValidator inputValidator = new InputValidator();
        List<String> cars = splitStringToList(carsString);
        inputValidator.checkCarsName(cars);
        inputValidator.checkInputValue(carsString);
    }

    private void checkForExceptionAttempts(String attempts){
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkInputValue(attempts);
        inputValidator.checkEttempts(attempts);
    }
}
