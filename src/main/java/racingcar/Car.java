package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    final String name;
    List<Integer> randomNumList;
    int forward = 0;
    Car(String name) {
        randomNumList = new ArrayList<>();
        this.name = name;

    }
    public void addRandomNum(int randomNum){
        randomNumList.add(randomNum);
    }
    public void increaseForward(){
        forward++;
    }

    private void validateCarNameLength(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("자동차의 이름은 6글자를 넘길 수 없습니다.");
        }
    }
}
