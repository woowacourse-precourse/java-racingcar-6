package racingcar;

import java.util.List;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input implements checkException {
    List<String> nameList;

    Input() {
        String nameString = Console.readLine();
        nameList = Arrays.asList(nameString.split(","));
    }

    public void print() {
        for (String carName : nameList)
            System.out.print(carName + " ");
        System.out.println();
    }

    @Override
     public boolean isValidNameLength(){
        return true;
    }

    @Override
    public boolean isBlankString(){
        return true;
    }

    public void exceptionHandling() throws IllegalArgumentException{
        if(!isValidNameLength() || isBlankString())throw new IllegalArgumentException();
    }


}