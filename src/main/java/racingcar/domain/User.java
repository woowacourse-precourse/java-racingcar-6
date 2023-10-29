package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public void decideMove(int order){

    }
    public List<String> initCarList(){
        String userInput = Console.readLine();
        List<String> nameList = Arrays.asList(userInput.split(","));
        return nameList;
    }
}
