package racingcar.service;


import java.util.ArrayList;
import java.util.List;

public class CarMove {

    List<Integer> LengthCount = new ArrayList<>();
    RandomNumber randomNumber = new RandomNumber();
    CarName carName = new CarName();

    public Integer increaseLength() {
        int length = 0;

        if (randomNumber.generate() >= 4) {
            length += 1;
        }
        return length;
    }

    public void lengthList() {
        for (int i = 0; i <carName.rangeCarList.size(); i++) {
            LengthCount.add(increaseLength());
        }
    }
}