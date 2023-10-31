package racingcar.utils;

import racingcar.model.Car;

import java.util.*;
public class Winner {
    public static List<Car> getWinners(List<Car> cars){
        int maxPosition=getMaxPosition(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars){
            if (car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars){
        int maxPosition=0;

        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

}

