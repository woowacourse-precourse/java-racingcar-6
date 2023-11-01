package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static List<Car> carList;
    public CarList(List<String> nameList){
        for (String name : nameList) {
            carList.add(new Car(name));
        }
    }
    public static void carListMove() {
        for (Car car : carList) {
            car.randomMove();
        }
    }
    public static List<String> carListWinners(){
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

}
