package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    List<Car> cars;
    List<String> maxCars = new ArrayList<>();

    public Winner(List<Car> cars){
        this.cars = cars;
    }

    public List<String> whoIsWinner(){
        int max = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            max = checkMaxDistance(max, car);
        }

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            checkWinner(max, car);
        }

        return maxCars;
    }

    private void checkWinner(int max, Car car) {
        if(car.getDistance()== max){
            maxCars.add(car.getName());
        }
    }

    private static int checkMaxDistance(int max, Car car) {
        if(car.getDistance() > max){
            max = car.getDistance();
        }
        return max;
    }
}
