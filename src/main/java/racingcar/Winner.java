package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<Car> setWinnerList(List<Car> carList){
        List<Car> winnerList = new ArrayList<>();
        int maxStep = carList.get(0).getStep();
        for (Car car : carList) {
            if (car.getStep() > maxStep) {
                maxStep = car.getStep();
            }
        }
        for (Car car : carList) {
            if (car.getStep() == maxStep) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

}
