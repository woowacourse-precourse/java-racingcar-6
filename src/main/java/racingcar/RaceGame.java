package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public void startGame(){
        consoleOutput.printInputCarName();
        String carsString = userInput();
        List<String> cars = splitStringToList(carsString);
        System.out.println(cars);
        //입력값 예외 체크
        checkForException(carsString);
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
        inputValidator.checkNameLength(cars);
        //자동차 이름 띄어쓰기 검사
        inputValidator.checkInputForSpaces(carsString);
        //입력값 비었는지 검사
        inputValidator.checkInputEmpty(carsString);
    }
}
