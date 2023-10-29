package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String getCarNames(){
        return Console.readLine();
    }

    public static Integer getRoundCount(){
        String roundCount = Console.readLine();
        checkIfNumeric(roundCount);
        return Integer.parseInt(roundCount);
    }

    public static void checkIfNumeric(String userInput){
        if(!userInput.matches("[0-9]+"))
            throw new IllegalArgumentException();
    }
}
