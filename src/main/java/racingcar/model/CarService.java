package racingcar.model;

import java.util.ArrayList;

import racingcar.model.Car;
public class CarService {
    public ArrayList<String> decideWinner(ArrayList<Car> carsList) {
        ArrayList<String> winnerNameList = new ArrayList<>();
        int maxValue = 0;
        for (Car car : carsList) {
            maxValue = Math.max(maxValue,car.getLocation());
        }
        for (Car car : carsList) {
            if (car.getLocation() == maxValue) {
                winnerNameList.add(car.getName());
            }
        }
        return winnerNameList;
    }
}
