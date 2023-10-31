package racingcar;

import java.util.List;

public class Play {
    RandomNum randomNum = new RandomNum();
    public List<Car> playRound(List<Car> Cars) {
        for(Car car : Cars) {
            int random_num = randomNum.createRandomNum();
            if(random_num >= 4) {
                car.score++;
            }
        }
        return Cars;
    }
}
