package racingcar.model;

import java.util.List;

public class WinningResult {
    public int winningScore = 0;
    public void winnerScore(List<Car> cars){
        for(int i = 0; i < cars.size(); i++){
            if(winningScore < cars.get(i).getPosition()) winningScore = cars.get(i).getPosition();
        }
    }
}
