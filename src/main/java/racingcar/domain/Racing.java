package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public void run(){

    }

    private List<Car> toCarList(List<String> carNameList){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private boolean isMove(Car car){
        return car.getRandomNum() >= 4;
    }

    private void modifyForwardNum(List<Car> carList){

    }

    private List<String> findWinners(List<Car> carList){

    }

    private void initCarsRandomNum(List<Car> carList){

    }
}
