package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int inputInteger(){
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        return number;
    }

    public String inputString(){
        String inputName = Console.readLine();
        return inputName;
    }
}
