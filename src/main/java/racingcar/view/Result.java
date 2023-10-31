package racingcar.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;

public class Result {
    public static void printResult(List<Car> carList){
        StringBuilder result = new StringBuilder();
        for(Car car : carList){
            result.append(car.getCarName()).append(" : ");
            result.append(printDistance(car.getDistance()));
            result.append(System.lineSeparator());
        }
        System.out.println(result);
    }

    public static String printDistance(int distance){
        StringBuilder distanceBuilder = new StringBuilder();
        for(int i = 0; i < distance; i++){
            distanceBuilder.append("-");
        }
        return distanceBuilder.toString();
    }

    public static void printWinner(List<Car> carList){
        System.out.print("최종 우승자 : ");
        int maxDistance = getMaxNumber(carList);
        StringJoiner winner = new StringJoiner(", ");
        for(Car car : carList){
            if(maxDistance == car.getDistance()){
                winner.add(car.getCarName());
            }
        }
        System.out.print(winner);
    }

    public static int getMaxNumber(List<Car> carList){
        Car maxDistanceCar = Collections.max(carList, Comparator.comparingInt(Car::getDistance));
        return maxDistanceCar.getDistance();
    }
}
