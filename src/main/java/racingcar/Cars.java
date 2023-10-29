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
        List<String> winnerCarList = new ArrayList<>();
        int maxForward = -1;

        for(Car car : carList) {
            if(car.getForward() > maxForward) {
                maxForward = car.getForward();
                winnerCarList.clear();
            }

            if (car.getForward() == maxForward) {
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }

}
