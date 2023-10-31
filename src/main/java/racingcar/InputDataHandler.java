package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputDataHandler {

    public InputValidator inputValidator = new InputValidator();
    public String[] carNames;
    private HashMap<String, Integer> cars = new HashMap<>();
    private String input;
    private String attemptNumber;

    public String[] getStringFromPlayer(){
        input = Console.readLine();
        carNames = seperateString(input);
        for(String names : carNames){
            inputValidator.checkStringLength(names);
        }
        return carNames;
    }

    public int getNumberFromPlayer(){
        attemptNumber = Console.readLine();
        inputValidator.checkNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }

    public String[] seperateString(String inputCarNames){
        return inputCarNames.split(",");
    }

    public String findCarName(int index){
        return carNames[index];
    }

    public int findCarMovement(String carName){
        return cars.get(carName);
    }
}
