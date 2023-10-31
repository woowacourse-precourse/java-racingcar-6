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

        cars.forEach(car -> {
            int score = car.getScore();
            
            if(score > maxScore[0]) {
                maxScore[0] = score;
                winner.clear();
                winner.add(car.getName());
            } else if (score == maxScore[0]) {
                winner.add(car.getName());
            }
            
        });

        return winner;
    }
}
