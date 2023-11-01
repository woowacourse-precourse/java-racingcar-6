package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.List;

public class SaveCarList {
    private CarList carList;

    public SaveCarList(CarList carList){
        this.carList = carList;
    }
    public void addCar(Car car) {
        //domain에서 정의한 CarList에 저장.
        carList.addCar(car);
    }

    public CarList entireCarList(){
        return carList;
        //return carList.getCarList();
    }
}
