package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputDataHandler {

    public InputValidator inputValidator = new InputValidator();
    private String[] carNames;
    private HashMap<String, Integer> cars = new HashMap<>();
    private String inputCarNames;
    private String attemptNumber;

    public HashMap<String, Integer> getStringFromPlayer(){
        inputCarNames = Console.readLine();
        carNames = seperateString(inputCarNames);
        for(String names : carNames){
            if (inputValidator.checkStringLength(names)){
                cars.put(names, 0);
            }
        }
        return cars;
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
