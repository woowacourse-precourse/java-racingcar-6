package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public List<String> compare(List<Car> carsAfteRace){
        List<String> winners = new ArrayList<>();
        int maxScore = -1;

        for(Car car : carsAfteRace){
            if(car.getScore()>maxScore){
                maxScore = car.getScore();
                winners.clear();
                winners.add(car.getName());
            }else if(car.getScore() == maxScore){
                winners.add(car.getName());
            }
        }

        return winners;
    }

}
