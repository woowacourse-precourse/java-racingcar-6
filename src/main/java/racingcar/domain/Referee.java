package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public List<String> getWinner(List<Car> carList) {
        List<String> winnerName = new ArrayList<>();
        int maxPath = 0;

        for (Car car : carList) {
            if (car.getPath() > maxPath) {
                maxPath = car.getPath();
                winnerName.clear();
                winnerName.add(car.getName());
            } else if (car.getPath() == maxPath) {
                winnerName.add(car.getName());
            }
        }

        return winnerName;
    }
}
