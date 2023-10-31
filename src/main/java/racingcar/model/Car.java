package racingcar.model;

import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int STANDARD_VALUE = 4;
    private static final int START_POSITION = 0;

    private final CarName carName;
    private int position ;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position= START_POSITION;
    }
    public void go(){
        int random = RandomUtil.createRandomNumber();
        if(random>=STANDARD_VALUE){
            position++;
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public String getPosition() {
        String bar = "";
        for (int  i = 0;i<position;i++){
            bar += "-";
        }
        return bar;
    }
}
