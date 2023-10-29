package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void playSingleTurn(){
        for (Car car : cars) {
            car.move();
        }
    }




}
