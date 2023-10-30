package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputDataHandler {

    public InputValidator inputValidator = new InputValidator();
    private String inputCarNames;
    private String[] carNames;
    private HashMap<String, Integer> cars = new HashMap<>();

    public void getStringFromPlayer(){
        inputCarNames = Console.readLine();
        carNames = seperateString(inputCarNames);
        inputValidator.checkStringLength(carNames);
    }

    public String[] seperateString(String inputCarNames){
        return inputCarNames.split(",");
    }
}
