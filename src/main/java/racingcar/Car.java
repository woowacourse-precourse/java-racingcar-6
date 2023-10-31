package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    final String name = "";
    List<Integer> randomNumList;
    int forward = 0;
    Car(String name) {
        randomNumList = new ArrayList<>();
    }
    public void addRandomNum(int randomNum){
        randomNumList.add(randomNum);
    }
    public void increaseForward(){
        forward++;
    }
}
