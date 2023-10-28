package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int step;
    public Car(String name){
        this.name = name;
        step = 0;
    }
    public void tryOneStep(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(randomNumber>=4){
            step++;
        }
    }


    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }
}
