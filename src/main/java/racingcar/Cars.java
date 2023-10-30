package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void updateForwardCar() {
        for (Car car : carList) {
            if(isForward(Randoms.pickNumberInRange(0, 9)))
                car.moveForward();
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinnerCarNameList() {
        int maxForward = findMaxForward();
        return findWinnerCarNames(maxForward);
    }

    private int findMaxForward() {
        int maxForward = -1;
        for (Car car : carList) {
            maxForward = Math.max(maxForward, car.getForward());
        }
        return maxForward;
    }

    private List<String> findWinnerCarNames(int maxForward) {
        List<String> winnerCarList = new ArrayList<>();
        for (Car car : carList) {
            if (maxForward == car.getForward()) {
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }

}
