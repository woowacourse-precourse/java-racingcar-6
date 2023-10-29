package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;
    public Racing(List<Car> carList){
        this.carList = carList;
    }
    public Boolean isGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public List<String> determineWinner() {
        int maxMove = getMax();
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.move == maxMove) {
                winner.add(car.name);
            }
        }

        return winner;
    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.move > max) {
                max = car.move;
            }
        }
        return max;
    }
}

