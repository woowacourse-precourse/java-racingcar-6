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
        checkForException(cars);
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

    private void checkForException(List<String> cars){
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkNameLength(cars);
    }
}
