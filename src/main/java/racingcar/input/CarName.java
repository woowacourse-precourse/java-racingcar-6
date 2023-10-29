package racingcar.input;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class CarName {

    public List<String> validatedUserInput(){
        String userInput = Console.readLine();
        return valid(userInput);
    }

    public List<String> valid(String userInput){
        String[] userInputSplit = userInput.split(",");
        List<String> carNames = Arrays.asList(userInputSplit);
        for(String carName : carNames){
            notFiveOrLess(carName);
        }
        return carNames;
    }

    public void notFiveOrLess(String carName) throws IllegalArgumentException{
        if(carName.length() > 5){
            throw new IllegalArgumentException();
        }
    }

}
