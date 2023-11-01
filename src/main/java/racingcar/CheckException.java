package racingcar;

import java.util.*;
public class CheckException {
    static void checkRightCarName(Set<String> carNameSet){
        boolean hasInvalidName = false;
        for (String name : carNameSet){
            if (name.length() > 5) {
                hasInvalidName = true;
                break;
            }
        }
        if (hasInvalidName) {
            throw new IllegalArgumentException();
        }
    }

    static int checkRightNumberOfMove(String move){
        try{
            return Integer.parseInt(move);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Input should be convert to number");
        }
    }

    static int checkPositiveNumberOfMove(int num){
        if (num > 0){
            return num;
        }
        else{
            throw new IllegalArgumentException("Input should be a positive number");
        }
    }
}
