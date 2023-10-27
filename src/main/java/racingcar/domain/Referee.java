package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public String announcementWinners(List<Car> carList) {
        List<Car> winners = selectionWinners(carList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private List<Car> selectionWinners(List<Car> carList) {
        int maxDistance = calculateMaxDistance(carList);
        return findWinners(carList, maxDistance);
    }

    private int calculateMaxDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::distance)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private List<Car> findWinners(List<Car> carList, int maxDistance) {
        return carList.stream()
                .filter(car -> car.distance() == maxDistance)
                .collect(Collectors.toList());
    }
}
