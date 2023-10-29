package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Car {
    private String name;
    private static int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public static void putCarResult(){
        if(checkForwardOrBackward(getRandomNumber()) == 1){
            count ++;
        }
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public int checkForwardOrBackward(int number){
        if(number >= 4){
            return 1;
        }else{
            return 0;
        }
    }
}
