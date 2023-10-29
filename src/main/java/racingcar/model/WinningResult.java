package racingcar.model;

import java.util.List;

public class WinningResult {
    public int winnerScore(List<Car> cars){

        int maxScore = 0;
        for(int i = 0; i < cars.size(); i++){
            if(maxScore < cars.get(i).getPosition()) maxScore = cars.get(i).getPosition();
        }
        return maxScore;
    }
}
