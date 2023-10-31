package racingcar.game;

import java.util.ArrayList;

public class Cars {
    ArrayList<Car> cars = new ArrayList<>();

    public Cars(ArrayList<String> inputList){
        for (String s : inputList) {
            cars.add(new Car(s));
        }
    }

    public void getCarNames(){
        for (Car car : cars) {
            System.out.printf("차 이름(%s) ", car.getCarName());
        }
    }

    public Integer getNumberOfCars(){
        return cars.size();
    }
}
