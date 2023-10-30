package racingcar.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final static List<Car> carList = new ArrayList<>();

    public void init(String[] carArr) {
        for (String carName : carArr) {
            carList.add(new Car(carName, 0));
        }
    }

    public List<Car> getCarList() {
        return unmodifiableList(carList);
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
}