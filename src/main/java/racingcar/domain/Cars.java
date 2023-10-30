package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars{

    List<Car> carList;

    public Cars(List<String> carList){
        this.carList = nameListIntoCarList(carList);
    }

    private List<Car> nameListIntoCarList(List<String> names){
        List<Car> cars= new ArrayList<>();
        for (String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getCarList(){
        return carList;
    }

}
