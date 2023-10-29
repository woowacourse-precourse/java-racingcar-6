package racingcar.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Rule;

public class InputException {
    public void validCarName(List<String> names){
        for(String name : names){
            if (name.length() > Rule.maxCarName){
                throw new IllegalArgumentException();
            }
        }
    }

    public int changeStringToInt(String userInput){
        try{
            return Integer.parseInt(userInput);
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    public List<String> divideCarNames(String userInput){
        try{
            return new ArrayList<String>(Arrays.asList(userInput.split(",")));
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
}
