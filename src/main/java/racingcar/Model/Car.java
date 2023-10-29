package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void putCarResult(int forwardOrBackward){
        if(forwardOrBackward == 1){
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
