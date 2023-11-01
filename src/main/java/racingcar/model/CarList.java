package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public List<Car> carList;
    public CarList(List<String> nameList){
        carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
    }
    public void carListMove() {
        for (Car car : carList) {
            car.randomMove();
        }
    }
    public List<String> carListWinners(){
        int maxMoveCount = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.moveCount > maxMoveCount) {
                maxMoveCount = car.moveCount;
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        return winners;
    }
    public String carListMoveCountString(){
        String carListMoveCountString = "";
        for (Car car : carList) {
            carListMoveCountString += car.moveCountString() + '\n';
        }
        return carListMoveCountString;
    }

}
