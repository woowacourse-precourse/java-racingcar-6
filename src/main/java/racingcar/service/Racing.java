package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> racingCars;

    public void setRacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars(){
        return racingCars;
    }

    public List<Car> race(){
        for(Car car: racingCars){
            car.drive();
        }
        return racingCars;
    }

    public List<String> getWinner(){
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for(Car car: racingCars){
            int position = car.getPosition();
            if(position > maxPosition){
                maxPosition = position;
                winners.clear();
                winners.add(car.getName());
            } else if (position == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
