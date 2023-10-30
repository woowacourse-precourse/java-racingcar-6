package racingcar;

import java.util.*;
public class CheckException {
    static void checkRightCarName(Set<String> carNameSet){
        for (String name : carNameSet){
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int checkRightNumberOfMove(String move){
        try{
            return Integer.parseInt(move);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    static int checkPositiveNumberOfMove(int num){
        if (num > 0){
            return num;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
