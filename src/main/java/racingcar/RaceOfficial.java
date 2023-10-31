package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceOfficial {
    private List<Car> winners;
    public void findAndSetWinners(List<Car> cars) {
        int longestDistance = findLongestDistance(cars);

        winners = cars.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .collect(Collectors.toList());
    }

    public int findLongestDistance(List<Car> cars) {
        return (int) cars.stream()
                .map(Car::getDistance)
                .min(Comparator.reverseOrder())
                .orElse(0);
    }

    public void reportWinners() {
        List<String> names = winners.stream().map(Car::getName).collect(Collectors.toList());
        String allWinners = String.join(", ", names);

        Util.print(MessageType.SHOW_WINNERS, allWinners);
    }
}