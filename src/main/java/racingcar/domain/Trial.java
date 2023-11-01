package racingcar.domain;

import java.util.HashMap;

public class Trial {
    public HashMap<String, Integer> moveForward(HashMap<String, Integer> distanceOfCars) {
        for (String car : distanceOfCars.keySet()) {
            Integer distance = distanceOfCars.get(car);
            if (Referee.checkMoveForward()) {
                distanceOfCars.replace(car, distance+1);
            }
        }
        return distanceOfCars;
    }
}
