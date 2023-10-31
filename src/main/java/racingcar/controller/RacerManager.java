package racingcar.controller;

import racingcar.model.Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RacerManager {

    public static List<String> seperateRacersName(String input) {
        String[] cars = input.split(",");
        return Arrays.asList(cars);
    }

    public static List<Racer> createRacers(List<String> racerNames) {
        List<Racer> racers = new ArrayList<>();
        for (String racerName : racerNames) {
            Racer car = new Racer(racerName);
            racers.add(car);
        }
        return racers;
    }
}
