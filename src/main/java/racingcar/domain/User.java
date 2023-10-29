package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final int GO_STRAIGHT_NUMBER = 4;
    public boolean decideMove(int order){
        if(order >= GO_STRAIGHT_NUMBER){
            return true;
        }
        return false;
    }
    public List<String> initCarList(){
        String userInput = Console.readLine();
        List<String> nameList = Arrays.asList(userInput.split(","));
        return nameList;
    }
}
