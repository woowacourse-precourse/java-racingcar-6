package racingcar.game;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Result {
    public List<String> showWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        sortByLocation(cars);
        addWinner(cars, winners);
        return winners;
    }
    private void addWinner(List<Car> cars, List<String> winners) {
        winners.add(cars.get(0).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getLocation().length() != cars.get(0).getLocation().length()) {
                break;
            } else {
                winners.add(cars.get(i).getName());
            }
        }
    }
    private void sortByLocation(List<Car> cars) {
        Comparator<Car> cp = (o1, o2) -> o2.getLocation().length() - o1.getLocation().length();
        cars.sort(cp);
    }
}
