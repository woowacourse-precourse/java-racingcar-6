package racingcar.Service;

import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(String inputCarsString){
        this.cars = this.createCars(inputCarsString);
    }
    public List<Car> createCars(String inputCarsString){

        List<String> carNames = new ArrayList<String>();
        Collections.addAll(carNames, inputCarsString.split(","));

        List<Car> carList = new ArrayList<>();
        for(String name : carNames){
            carList.add(new Car(name, 0));
        }

        return carList;
    }

    public ArrayList<Car> racing(){
        return null;
    }

    public ArrayList<Car> findWinners(){
        return null;
    }

}
