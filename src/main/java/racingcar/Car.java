package racingcar;

import static racingcar.ExceptionMessage.DUPLICATE_CAR_NAME;

import java.util.ArrayList;
import java.util.List;

public class Car {
    Name name;
    List<Integer> randomNumList;
    int forward = 0;
    Car(String name) {
        randomNumList = new ArrayList<>();
        this.name = new Name(name);

    }
    public void addRandomNum(int randomNum){
        randomNumList.add(randomNum);
    }
    public void increaseForward(){
        forward++;
    }

}
