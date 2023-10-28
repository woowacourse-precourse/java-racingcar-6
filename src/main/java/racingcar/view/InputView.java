package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> insertCarName(){
        String input = Console.readLine();
        List<String> names = toStringList(input);
        return names;
    }

    public List<String> toStringList(String name){
        List<String> names = Arrays.asList(name.split(","));
        validateName(names);
        return names;
    }

    public void validateName(List<String> names){
        if(!isAllFiveOrLess(names))
            throw new IllegalArgumentException("String index out of range: 5");
    }

    public boolean isAllFiveOrLess(List<String> names){
        for(String name : names){
            if(name.length()>5) return false;
        }
        return true;
    }


}
