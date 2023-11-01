package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Race {
    int max = 0;

    public void raceCar(List<Car> cars, int times){

        while(times > 0){
            System.out.print("\n");
            for (Car car : cars) {
                String position = car.getPosition();
                car.moveForward();
                System.out.println(car.getName() + " : " + position);
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
            int i = 0;
            for (String winner : winners) {
                System.out.print(winner);
                if (i < winners.size() - 1) {
                    System.out.print(",");
                }
                i++;
            }
            System.out.println();
        }
    }
}