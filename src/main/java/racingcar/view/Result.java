package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Result {
    public void printResult(List<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            Car car = carList.get(i);
            System.out.print(car.getCarName());
            System.out.print(" : ");
            printDistance(car.getDistance());
            System.out.println();
        }
        System.out.println();
    }

    public void printDistance(int distance){
        for(int i = 0; i < distance; i++){
            System.out.print("-");
        }
    }
}
