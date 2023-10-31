package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Car;

public class Race {
    private final List<String> currentPositions = new ArrayList<>();
    private final Map<String, String> raceResult = new HashMap<>();

    public String raceCar(List<Car> cars, int times){

        while(times > 0){
            System.out.print("\n");
            for (Car car : cars) {
                int move = car.moveForward();
                String position = car.getPosition();
                System.out.println(car.getName() + " : " + move + position);
                currentPositions.add(position);
            }
            times--;
        }

        cars.forEach(car -> {
            String name = car.getName();
            String position = car.getPosition();
            raceResult.put(name,position);
        });
        System.out.println(raceResult);

        return "게임종료";
    }


    public void raceResult(){

    }
}
