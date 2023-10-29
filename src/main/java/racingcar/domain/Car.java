package racingcar.domain;

import static racingcar.view.InputView.askCarName;

import java.util.ArrayList;
import java.util.List;


public class Car {
    private final String name;
    private int distance;
    private int randomNumber;

    private Car(String name) {
        this.name = name;
    }

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
