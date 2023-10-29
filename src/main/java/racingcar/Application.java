package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static CarsManage carsManage = new CarsManage();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        carsManage.inputCars();
        carsManage.straightCars();
        for (Car car: carsManage.cars
             ) {
            System.out.println(car.getName() + " "+car.getStraight());
        }
        List<String> winner = new ArrayList<>();
        winner = carsManage.chooseWinner();
        System.out.println(winner);
    }
}
