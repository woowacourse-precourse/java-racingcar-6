package racingcar.domain;

import java.util.List;

public class Trial {
    public List<Integer> moveForward(List<Integer> distanceOfCars) {
        for (int i = 0; i < distanceOfCars.size(); i++) {
            int distance = distanceOfCars.get(i);
            if (Referee.checkMoveForward()) {
                distanceOfCars.set(i, distance+1);
            }
        }
        return distanceOfCars;
    }
}
