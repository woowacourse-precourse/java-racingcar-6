package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUser {
    public List<String> getNames(){
        String userInput = Console.readLine();
        List<String> names = new ArrayList<>(Arrays.asList(userInput.split(",")));
        return names;
    }
    public int getNumber(){
        int getNum = Integer.parseInt(Console.readLine());
        return getNum;
    }
}
