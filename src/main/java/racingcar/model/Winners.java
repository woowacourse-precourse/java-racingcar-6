package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winnerList = new ArrayList<>();

    public void addWinner(Car winnerCar) {
        winnerList.add(winnerCar);
    }

    
    public List<Car> getWinner() {
        return winnerList;
    }
}
