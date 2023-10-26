package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;

public class FindWinnerController {
    private final List<Car> cars;
    private final List<String> winnerCars;

    public FindWinnerController(List<Car> cars){
        this.cars = new ArrayList<>(cars);
        winnerCars = new ArrayList<>();
    }

    public List<String> getWinners(){

        sortedCarByAdvances();
        findWinner();

        return winnerCars;
    }

    private void sortedCarByAdvances(){
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getCarAdvances() - o1.getCarAdvances();
            }
        });
    }

    public void findWinner() {

        Car winnerCar = cars.get(0);

        for (Car car : cars) {
            if(car.getCarAdvances() == winnerCar.getCarAdvances()){
                winnerCars.add(car.getCarName());
            }
        }
    }
}
