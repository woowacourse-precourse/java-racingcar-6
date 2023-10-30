package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputDataHandler {

    public InputValidator inputValidator = new InputValidator();
    private String[] carNames;
    private HashMap<String, Integer> cars = new HashMap<>();
    private String inputCarNames;
    private int attemptNumber;

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
        attemptNumber = Integer.parseInt(Console.readLine());

    }

    public String[] seperateString(String inputCarNames){
        return inputCarNames.split(",");
    }
}
