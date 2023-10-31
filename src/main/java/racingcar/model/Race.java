package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    private Map<Car,Integer> MovingDistance;

    public Race() {
        MovingDistance = new LinkedHashMap<>();
    }

    public void addCar(Car car) {
        MovingDistance.put(car, 0);
    }

    public void run() {
        for (Car car : MovingDistance.keySet()) {
            MovingDistance.put(car, MovingDistance.get(car) + car.move());
        }
    }

    public String toResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : MovingDistance.keySet()) {
            result.append(car.name()).append(" : ");
            for(int i = 0; i < MovingDistance.get(car); i++){
                result.append("-");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String getWinner(){
        int maxDistance = 0;
        for (Car car : MovingDistance.keySet()) {
            if (MovingDistance.get(car) > maxDistance) {
                maxDistance = MovingDistance.get(car);
            }
        }
        StringBuilder winner = new StringBuilder();
        for (Car car : MovingDistance.keySet()) {
            if (MovingDistance.get(car) == maxDistance) {
                winner.append(car.name()).append(", ");
            }
        }
        return winner.substring(0, winner.length() - 2);
    }

    public Map<Car, Integer> getMovingDistance() {
        return MovingDistance;
    }
}
