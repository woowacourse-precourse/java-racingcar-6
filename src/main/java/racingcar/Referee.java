package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {

    public List<Integer> saveAllDistances(List<Car> racingCars) {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            Car car = racingCars.get(i);
            distances.add(car.changeDistanceToInt());
        }
        return distances;
    }

    public int findMaxDistance(List<Integer> distances) {
        return Collections.max(distances);
    }


}