package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList;

    public CarList(String carsName){
        this.carList = new ArrayList<>();
        String[] names = splitNamesByComma(carsName);
    }

    private String[] splitNamesByComma(String name){
        return name.split(",");
    }

}
