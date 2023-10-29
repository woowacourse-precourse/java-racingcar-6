package racingcar.domain;

import static racingcar.view.InputView.askCarName;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList;
    public List<Car> createCars(String name){
        String names = askCarName();
        String[] nameArr = name.split(",");
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < nameArr.length; i++){
            cars.add(new Car(nameArr[i]));
        }
        return cars;
    }
}
