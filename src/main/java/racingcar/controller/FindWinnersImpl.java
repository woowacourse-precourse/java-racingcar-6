package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class FindWinnersImpl implements FindWinners{

    public List<String> getWinner(List<Car> cars) {

        int max=0;
        Car car;
        List<String> winners=new ArrayList<>();

        for(int i=0;i< cars.size();i++){
            car = cars.get(i);
            if(max < car.getMoveCount()){
                max = car.getMoveCount();
            }
        }

        String name;
        for(int i=0;i<cars.size();i++){
            car=cars.get(i);
            if(max == car.getMoveCount()){
                name=car.getName();
                winners.add(name);
            }
        }

        return winners;

    }
}
