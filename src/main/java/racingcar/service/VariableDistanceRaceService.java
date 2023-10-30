package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.AppConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public class VariableDistanceRaceService implements RaceService{

    @Override
    public Map<Car,Integer> runRace(Participants participants) {
        Map<Car,Integer> map = new LinkedHashMap<>();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Car car = participants.get(i);

            int distance = getRandomValue();
            boolean canMove = moveOrNot(distance);

            map.put(car, distance);
            if(canMove) {
                car.move(distance);
            }
        }
        return map;
    }

    private static boolean moveOrNot(int distance) {
        return distance > AppConfig.MOVE_CRITERIA;
    }
}
