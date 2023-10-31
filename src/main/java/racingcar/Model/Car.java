package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int count;

    public Car(String name){
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void putCarResult(){
        if(checkForwardOrStop(getRandomNumber()) == 1){
            count ++;
        }
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public int checkForwardOrStop(int number){
        if(number >= 4){
            return 1;
        }else{
            return 0;
        }
    }
}
