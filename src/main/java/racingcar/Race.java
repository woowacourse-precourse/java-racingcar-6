package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Car;

public class Race {
    private final Map<String, String> raceResult = new HashMap<>();
    int max = 0;

    public void raceCar(List<Car> cars, int times){
        while(times > 0){
            System.out.print("\n");
            for (Car car : cars) {
                int move = car.moveForward();
                String position = car.getPosition();
                System.out.println(car.getName() + " : " + position);
            }
            times--;
        }
        raceResult(cars);
    }

    public void updateResult(List<Car> cars){
        cars.forEach(car -> {
            String name = car.getName();
            String position = car.getPosition();
            raceResult.put(name,position);
            if (position.length() > max){
                max  = position.length();
            }
        });
    }

    public void raceResult(List<Car> cars){
        updateResult(cars);
        cars.forEach(car -> {
            String name = car.getName();
            String position = car.getPosition();
            if (position.length() == max) {
                System.out.print("최종 우승자 : " + name + " ");
            }
        });
    }
}
