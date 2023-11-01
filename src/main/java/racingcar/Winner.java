package racingcar;

import java.util.ArrayList;
import java.util.List;


public class Winner {
    private List<String> winners = new ArrayList<>();

    public List<String> returnWinner(int maxLength, List<Car> carResults) {
        for (Car car :
                carResults) {
            if (findWinner(maxLength, car.getCarName())) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    public boolean findWinner(int maxLength, String carResult) {
        return maxLength == carResult.length();
    }

}
