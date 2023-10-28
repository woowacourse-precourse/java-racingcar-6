package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<Car> decideWinner(List<Car> cars){
        int maxDistance=findWinnerDistance(cars);
        return cars.stream().filter(car->car.located()==maxDistance).collect(Collectors.toList());
    }

    private int findWinnerDistance(List<Car> cars){
        int maxDistance=0;
        for(int i=0;i<cars.size();i++){
            if(maxDistance<cars.get(i).located()){
                maxDistance=cars.get(i).located();
            }
        }
        return maxDistance;
    }

    public int calculateNumberOfWinner(){
        return 0;
    }

    public String makeWinnerWithCommas(List<String> winners){
        return null;
    }

    public String announceWinner(String winners){
        return null;
    }
}
