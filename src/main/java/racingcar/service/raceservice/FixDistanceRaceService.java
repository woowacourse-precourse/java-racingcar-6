package racingcar.service.raceservice;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.AppConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public class FixDistanceRaceService implements RaceService {
    private static final int FIX_DISTANCE = 1;

    @Override
    public Map<Car,Integer> runRace(Participants participants) {
        Map<Car,Integer> map = new LinkedHashMap<>();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Car car = participants.get(i);

            int randomValue = getRandomValue();
            boolean canMove = MoveOrNot(randomValue);

            map.put(car, randomValue);
            if (canMove) {
                //VariableDistanceRaceService 와 이부분만 다름
                car.move(FIX_DISTANCE);
            }
        }
        return map;
    }

    private static boolean MoveOrNot(int randomValue) {
        return randomValue >= AppConfig.MOVE_CRITERIA;
    }
}
