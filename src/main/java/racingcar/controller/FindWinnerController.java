package racingcar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;

public class FindWinnerController {
    private final List<Car> cars;
    private final List<Car> winnerCars;

    public FindWinnerController(List<Car> cars){
        this.cars = new ArrayList<>(cars);
        winnerCars = new ArrayList<>();
    }

    public List<Car> getWinners(){

        sortedCarByAdvances();
        findWinner();
        findCoWinner();

        return Collections.unmodifiableList(cars);
    }

    private void sortedCarByAdvances(){
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getCarAdvances() - o1.getCarAdvances();
            }
        });
    }

    public void findCoWinner() {

        Car winnerCar = cars.get(0);

        for (Car car : cars) {
            if(car.getCarAdvances() == winnerCar.getCarAdvances()){
                winnerCars.add(car);
            }
        }
    }

    public void findWinner(){
        winnerCars.add(cars.get(0));
    }
}
