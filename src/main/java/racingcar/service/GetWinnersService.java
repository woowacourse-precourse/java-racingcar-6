package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public class GetWinnersService {

    public List<Car> getWinners(Participants participants) {
        Map<Integer, List<Car>> rankMap = getRankMap(participants);
        return rankMap.keySet()
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .map(key -> rankMap.get(key))
                .get();
    }
    private static Map<Integer,List<Car>> getRankMap(Participants participants) {
        HashMap<Integer, List<Car>> rankMap = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            Car car = participants.get(i);
            Integer position = car.getPosition();

            List<Car> samePositionList = rankMap.getOrDefault(car, new ArrayList<Car>());
            samePositionList.add(car);
            rankMap.put(position, samePositionList);
        }
        return rankMap;
    }
}
