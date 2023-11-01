package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int FOR_ONE_STEP = 4;

    String name;
    int step;
    public Car(String name){
        this.name = name;
        step = 0;
    }
    public void tryOneStep(){
        int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        if(randomNumber>=FOR_ONE_STEP){
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
