package racingcar;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> carList = new ArrayList<Car>();

    public void createCars(ArrayList<String> carNameList){
        carNameList.forEach((name)->{
            addCarToCarList(name);
        });
    }
    private void addCarToCarList(String carName){
        carList.add(new Car(carName));
    }

}
