package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String input(){
        return Console.readLine();
    }
    private String[] splitInput(String input){
        return input.split(",");
    }
    private int stringToInteger(String input){
        return Integer.parseInt(input);
    }
}
