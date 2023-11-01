package racingcar.controller;

import racingcar.view.View;
import racingcar.model.Race;
import racingcar.model.Car;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Controller {

    public static void runRace() {
        List<Car> cars = createCars();
        int rounds = View.getRounds();

        Race race = new Race(cars, rounds);
        race.run();
        View.displayWinners(getWinnersNames(race));

    }

    private static List<Car> createCars() {
        String[] names = View.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static String getWinnersNames(Race race) {
        List<Car> winners = race.getWinners();
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
