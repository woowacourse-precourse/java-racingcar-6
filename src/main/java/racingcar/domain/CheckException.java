package racingcar.domain;

import java.util.*;

public class CheckException {
    public void checkRightCarName(Set<String> carNameSet){
        boolean hasInvalidName = false;
        for (String name : carNameSet){
            if (name.length() > 5) {
                hasInvalidName = true;
                break;
            }
        }
        checkRightNamelength(hasInvalidName);
    }

    private void checkRightNamelength(boolean flag){
        if (flag) {
            throw new IllegalArgumentException();
        }
    }

    public int checkRightNumberOfMove(String move){
        try{
            return Integer.parseInt(move);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Input should be convert to number");
        }
    }

    public int checkPositiveNumberOfMove(int num){
        if (num > 0){
            return num;
        }
        else{
            throw new IllegalArgumentException("Input should be a positive number");
        }
    }
}
