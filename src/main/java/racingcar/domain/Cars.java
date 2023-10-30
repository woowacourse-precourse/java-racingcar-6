package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final static List<Car> carList = new ArrayList<>();

    public void init(String[] carArr) {
        for (String carName : carArr) {
            carList.add(new Car(carName, 0));
        }
    }

    public int size() {
        return carList.size();
    }

    public void plusGameNum(int i) {
        carList.get(i).plusPosition();
    }

    public String findName(int i) {
        return carList.get(i).getName().getName();
    }

    public int findGameNum(int i) {
        return carList.get(i).getPosition().getNum();
    }

    public int findMaxAdvanceNum() {
        int max = 0;
        for (Car car : carList) {
            max = Math.max(max, car.getPosition().getNum());
        }
        return max;
    }
}