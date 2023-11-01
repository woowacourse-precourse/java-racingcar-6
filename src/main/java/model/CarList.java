package model;

import java.util.ArrayList;
import java.util.List;

public class CarList implements CarListInterface{
    private List<Car> carList;

    public CarList() {
        this.carList = new ArrayList<>();
    }

    @Override
    public void setCarList(List<String> carNameList) {
        for(String carName : carNameList)
            carList.add(new Car(carName, 0));
    }

    @Override
    public List<String> getCarList() {
        return null;
    }

    @Override
    public void forwardCar(String carName) {

    }

    @Override
    public int getLocation(String carName) {
        return 0;
    }
}
