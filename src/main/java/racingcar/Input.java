package racingcar;

import java.util.List;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input implements checkException {
    List<String> nameList;
    final int maxNameLength=5;

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
        for(String carName:nameList){
            if(carName.length()==0 || carName.length()>maxNameLength)return false;
        }
        return true;
    }

    @Override
    public boolean isBlankString(){
        for (String carName: nameList){
            String blankString = " ".repeat(carName.length());
            if(carName.equals(blankString))return true;
        }
        return false;
    }

    public void exceptionHandling() throws IllegalArgumentException{
        if(!isValidNameLength() || isBlankString())throw new IllegalArgumentException();
    }


}