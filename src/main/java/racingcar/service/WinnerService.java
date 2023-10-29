package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;

public class WinnerService {

    public static List<String> getWinnerNames(CarRepository carRepository) {
        Map<Integer, List<Car>> rankMap = partitioningByRank(carRepository);
        List<Car> winnerCarList = getWinnerList(rankMap);
        return convertCarsToStrings(winnerCarList);
    }

    public static Map<Integer, List<Car>> partitioningByRank(CarRepository carRepository) {
        HashMap<Integer, List<Car>> map = new HashMap<>();
        int size = carRepository.size();
        for (int i = 0; i < size; i++) {
            Car car = carRepository.getCar(i);
            int position = car.getPosition();

            List<Car> samePositionList = map.getOrDefault(position, new ArrayList<Car>());
            samePositionList.add(car);
            map.put(position, samePositionList);
        }
        return map;
    }

    public static List<Car> getWinnerList(Map<Integer, List<Car>> rankMap) {
        return rankMap.keySet()
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .map(key -> rankMap.get(key))
                .get();
    }

    public static List<String> convertCarsToStrings(List<Car> winnerCarList) {
        return winnerCarList
                .stream()
                .map(car -> car.getCarName().getName())
                .toList();
    }
}
