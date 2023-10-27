package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

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
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : carList) {
            int distance = car.distance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private List<Car> findWinners(List<Car> carList, int maxDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.distance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
