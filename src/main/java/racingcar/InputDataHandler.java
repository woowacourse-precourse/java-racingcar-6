package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputDataHandler {

    public InputValidator inputValidator = new InputValidator();
    private String inputCarNames;
    private String[] carNames;
    private HashMap<String, Integer> cars = new HashMap<>();

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

    public int get

    public String[] seperateString(String inputCarNames){
        return inputCarNames.split(",");
    }
}
