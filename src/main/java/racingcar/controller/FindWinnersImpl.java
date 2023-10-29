package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class FindWinnersImpl implements FindWinners{

    public List<Integer> getWinner(List<Car> cars) {

        int max=0;
        Car car;
        List<Integer> winners=new ArrayList<>();

        for(int i=0;i< cars.size();i++){
            car = cars.get(i);
            if(max < car.getMoveCount()){
                max = car.getMoveCount();
            }
        }

        for(int i=0;i<cars.size();i++){
            car=cars.get(i);
            if(max == car.getMoveCount()){
                winners.add(i);
            }
        }

        return winners;

    }
}
