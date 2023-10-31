package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Car;

public class Race {
    int max = 0;

    public void raceCar(List<Car> cars, int times){
        while(times > 0){
            System.out.print("\n");
            for (Car car : cars) {
                int move = car.moveForward();
                String position = car.getPosition();
                System.out.println(car.getName() + " : " + move + position);
            }
            times--;
        }
        raceResult(cars);
    }

    public void updateResult(List<Car> cars){
        cars.forEach(car -> {
            String position = car.getPosition();
            if (position.length() > max){
                max  = position.length();
            }
        });
    }

    public void raceResult(List<Car> cars){
        updateResult(cars);
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            String name = car.getName();
            String position = car.getPosition();
            if (position.length() == max) {
                winners.add(name);
            }
        });

        if (!winners.isEmpty()) {
            System.out.print("최종 우승자: ");
            for (String winner : winners) {
                System.out.print(winner + " ");
            }
            System.out.println();
        }
    }
}