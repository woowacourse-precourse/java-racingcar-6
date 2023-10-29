package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant.*;

public class UserInputHandler {

    public static InputValidator inputValidator;

    public UserInputHandler(){
        inputValidator = new InputValidator();
    }
    public String []  getInputForNames(){
        String inputData = Console.readLine();
        String [] names = StringOperator.seperate(inputData, GameConfig.CAR_NAME.getSeperator());
        for(String name : names){
            inputValidator.validateLength(name, GameConfig.CAR_NAME.getLimitLength());
        }
        return names;
    }
}
