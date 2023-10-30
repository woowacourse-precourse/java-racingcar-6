package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> getMaxForwardCountCarNames(Cars cars){
        List<String>carNames = new ArrayList<>();
        Collections.sort(cars.getCarList());
        for (Car car : carList){
            if(carList.get(0).getForwardCount()==car.getForwardCount()){
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    public List<Car> getCarList(){
        return carList;
    }

}
