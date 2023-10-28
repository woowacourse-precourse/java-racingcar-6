package racingcar.service;

import racingcar.model.Car;
import racingcar.util.ValidUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarManageService {
    private ValidUtil util = new ValidUtil();

    public List<String> createCarNameList(String names){
        List<String> carNameList = new ArrayList<>();
        util.checkNames(names);
        StringTokenizer st = new StringTokenizer(names, ",");
        while (st.hasMoreTokens()){
            carNameList.add(st.nextToken());
        }
        util.checkNameList(carNameList);
        return carNameList;
    }

    public List<Car> createCars(List<String> nameList){
        List<Car> cars = new ArrayList<>();
        for(String name : nameList){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void sortCarsByPoint(List<Car> cars) {
        cars.sort((car1, car2) -> {
            return car2.getPoint() - car1.getPoint();
        });
    }





}
