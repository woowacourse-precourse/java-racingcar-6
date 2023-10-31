package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class RacingMap {
    private List<Car> carList;

    public RacingMap(){
        carList = new ArrayList<>();
    }

    public void setCarList(List<Car> carList){
        this.carList = carList;
    }

    public void trial(){
        for(Car car: carList)
            car.trial();
    }

    public List<Car> getCarList(){

    }
}
