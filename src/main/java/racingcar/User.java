package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int input;
    public int numAttempt(){

        System.out.println("시도할 횟수를 입력해주세요");
        String attempt = Console.readLine();
        input = Integer.parseInt(attempt);
        return input;
    }
    public int getInput(){
        return input;
    }

}
