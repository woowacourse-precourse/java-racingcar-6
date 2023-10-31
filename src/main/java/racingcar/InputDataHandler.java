package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDataHandler {

    public String[] carNames;
    private String input;
    private String attemptNumber;

    public String[] getStringFromPlayer(){
        input = Console.readLine();
        carNames = seperateString(input);
        return carNames;
    }

    public String getNumberFromPlayer(){
        attemptNumber = Console.readLine();
        return attemptNumber;
    }

    public String[] seperateString(String inputCarNames){
        return inputCarNames.split(",");
    }
}
