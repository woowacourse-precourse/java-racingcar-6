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
    public static List<String> getWinnersNames(Participants participants) {
        Map<Integer, List<Car>> rankMap = getRankMap(participants);
        List<Car> winners = getWinners(rankMap);
        return convertCarToCarName(winners);
    }

    private static Map<Integer, List<Car>> getRankMap(Participants participants) {
        Map<Integer, List<Car>> rankMap = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            Car car = participants.get(i);
            Integer position = car.getPosition();

            List<Car> samePositionList = rankMap.getOrDefault(position, new ArrayList<Car>());
            samePositionList.add(car);
            rankMap.put(position, samePositionList);
        }
        return rankMap;
    }

    private static List<Car> getWinners(Map<Integer, List<Car>> rankMap) {
        return rankMap.keySet()
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .map(key -> rankMap.get(key))
                .get();
    }

    private static List<String> convertCarToCarName(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName().name())
                .toList();
    }
}
