package model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;
    private int maxPlace;

    public Winners(List<Car> cars) {
        searchMaxPlace(cars);
        searchWinners(cars);
    }

    public List<Car> getWinners() {
        return winners;
    }

    public int getMaxPlace(){
        return maxPlace;
    }
    public void searchMaxPlace(List<Car> cars) {
        maxPlace = cars.stream().map(car -> car.getNowPlace().length())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public void searchWinners(List<Car> cars) {
        winners = cars.stream().filter(car ->
                        car.getNowPlace().length() == maxPlace)
                .collect(Collectors.toList());
    }

    public boolean getMultipleWinners() {
        if (winners.size() == 1) {
            return false;
        }
        return true;
    }
}
