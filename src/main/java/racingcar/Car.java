package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private String name;
    private int location=0;

    public Car(String carName){
        name=carName;
    }
    public String getName(){
        return name;
    }
    public int getLocation(){
        return location;
    }

    public void tryMove(){
        int randomInt = Randoms.pickNumberInRange(0,9);
        if (randomInt>=4){
            location++;
        }
    }

}
