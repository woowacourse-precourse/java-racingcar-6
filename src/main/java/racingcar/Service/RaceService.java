package racingcar.Service;


import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceService {
    private int getMaxDistance(List<Car> cars){
        int maxDistnace = 0;
        for(Car car: cars){
            if(maxDistnace < car.getPosition()){
                maxDistnace = car.getPosition();
            }
        }
        return maxDistnace;
    }
    private List<Car> getWinner(List<Car> cars){
        List<Car> winners = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);
        for(Car car: cars){
            if( maxDistance == car.getPosition()){
                winners.add(car);
            }
        }
        return winners;
    }

    public void showResults(List<Car> cars){
        List<Car> winners = getWinner(cars);
        System.out.print("최종 우승자 : ");
        for(Car winner: winners){
            System.out.print(winner.getName()+" ");
        }
    }
}
