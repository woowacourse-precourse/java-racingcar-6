package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class Car {


    private int position;
    private String name;

    public Car(String name){
        this.name = name;
    }

    public void move(){
        this.position++;
    }





    public int createRandomNumber() {
        int carNumber = Randoms.pickNumberInRange(0, 9);
        return carNumber;
    }


}
