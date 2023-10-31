package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    
    // 모든 자동차들에 대해 한 번의 시도를 진행 후 출력
    public void doGame(List<Car> cars) {
        
        cars.forEach(car -> {
            if(rollDice() > 3) {
                car.addScore();
            }
            System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
            
        });
        
        System.out.println();
        
    }
    
    private int rollDice() {
        return Randoms.pickNumberInRange(0, 9);
    }
    
    public List<String> findWinner(List<Car> cars) {
        
        List<String> winner = new ArrayList<>();
        final int[] maxScore = {0};
        
        cars.forEach(car -> compareScore(car, winner, maxScore));

        return winner;
    }
    
    private void compareScore(Car car, List<String> winner, int[] maxScore) {
        int scoreToCompare = car.getScore();
        if(scoreToCompare > maxScore[0]) {
            maxScore[0] = scoreToCompare;
            winner.clear();
            winner.add(car.getName());
        } else if (scoreToCompare == maxScore[0]) {
            winner.add(car.getName());
        }
    }
    
}
