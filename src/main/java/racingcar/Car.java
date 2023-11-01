package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String state = "";
    String name;

    public Car(String n){
        name = n;
    }

    public int drawNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public String decideGo(int drawnumber){
        if (drawnumber >= 4){
            return state += "-";
        }
        if (drawnumber < 4){
            return state;
        }
        return "버그";
    }



}
