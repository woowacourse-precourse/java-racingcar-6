package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winnerList = new ArrayList<>(5);

    public void findWinner(List<Car> carList) {
        int max = findMax(carList);
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String name = car.getName();
            int move = car.getTotalMove();
            if (move >= max) {
                winnerList.add(name);
            }
        }
    }

    public int findMax(List<Car> carList) {
        int max = 0;
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String name = car.getName();
            int move = car.getTotalMove();
            if (move > max) {
                max = move;
            }
        }
        return max;
    }

    public List<String> getWinner() {
        return this.winnerList;
    }
}
