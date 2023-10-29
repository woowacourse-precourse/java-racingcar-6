package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Car {
    private String name;
    private static int count;

    public Car(String name){
        this.name = name;
        this.count = 0;
    }

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }
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

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static int checkForwardOrBackward(int number){
        if(number >= 4){
            return 1;
        }else{
            return 0;
        }
    }
}
