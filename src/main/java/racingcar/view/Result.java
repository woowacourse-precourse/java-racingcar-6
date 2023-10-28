package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    public void printWinner(List<Car> carList){
        int maxDistance = getMaxDistance(carList);
        boolean jointWinner = false;
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < carList.size(); i++){
            if(jointWinner == true){
                System.out.print(", ");
            }
            if(maxDistance == carList.get(i).getDistance()){
                System.out.print(carList.get(i).getCarName());
                jointWinner = true;
            }
        }
    }

    public int getMaxDistance(List<Car> carList){
        Car maxDistanceCar = Collections.max(carList, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Integer.compare(car1.getDistance(), car2.getDistance());
            }
        });
        return maxDistanceCar.getDistance();
    }
}
