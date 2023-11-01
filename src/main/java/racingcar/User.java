package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {


    private int input;
    public int numAttempt(){

        String attempt = Console.readLine();
        int input = Integer.parseInt(attempt);
        return input;
    }

}
