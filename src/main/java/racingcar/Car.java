package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{
    private final int count;
    private final String name;

    public Car(String inputName){
        this.count = Randoms.pickNumberInRange(0, 9);
        this.name = inputName;
    }

    public int getCount(){
        return count;
    }
    public String getName(){
        return name;
    }

}
