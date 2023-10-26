package service;

import domain.Cars;

public class GameService {

    private final Cars cars;

    public GameService() {
        cars = new Cars();
    }

    public void fillNames(String[] names) {
        cars.fill(names);
    }

    public String raceResult(int count) {
        return cars.getResult(count);
    }

    public String getWinners() {
        return cars.getWinners();
    }

}
