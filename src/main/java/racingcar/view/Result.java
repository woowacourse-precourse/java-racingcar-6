package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
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
        System.out.print("최종 우승자 : ");
        int maxDistance = getMaxNumber(carList);
        StringJoiner winner = new StringJoiner(", ");
        for(Car car : carList){
            if(maxDistance == car.getDistance()){
                winner.add(car.getCarName());
            }
        }
        System.out.println(winner);
    }

    public int getMaxNumber(List<Car> carList){
        Car maxDistanceCar = Collections.max(carList, Comparator.comparingInt(Car::getDistance));
        return maxDistanceCar.getDistance();
    }
}
