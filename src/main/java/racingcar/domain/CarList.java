package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarList {

    private final List<Car> carList;

    public CarList(String carNameString) {
        this.carList = new ArrayList<>();
        stringToCarList(carNameString);
    }

    private void stringToCarList(String carNameString) {
        StringTokenizer splitCarToken = new StringTokenizer(carNameString, ",");
        while (splitCarToken.hasMoreTokens()) {
            carList.add(new Car(splitCarToken.nextToken()));
        }
    }


    @Override
    public String toString() {
        return carList.toString();
    }
}
