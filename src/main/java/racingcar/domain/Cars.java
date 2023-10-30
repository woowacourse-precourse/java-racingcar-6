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
        int initialForwardCount=0;
        for (String name : names){
            cars.add(new Car(name,initialForwardCount));
        }
        return cars;
    }

    public List<Car> getCarList(){
        return carList;
    }

}
