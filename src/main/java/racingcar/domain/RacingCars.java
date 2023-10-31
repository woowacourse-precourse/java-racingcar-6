package racingcar.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.utils.Utils;

public class RacingCars {
    private final static LinkedHashMap<RacingCar, RacingResult> racingCars = new LinkedHashMap<>();

    public static String comparison() {
        return String.join(", ", getWinnerList(getMaxResult()));
    }

    private static List<String> getWinnerList(List<RacingResult> maxResult) {
        return maxResult.stream()
                       .map(value -> racingCars.entrySet().stream()
                                             .filter(entry ->
                                                             entry.getValue().length()
                                                                     == value.length())
                                             .map(e -> String.valueOf(e.getKey().toString()))
                                             .collect(Collectors.toList()))
                       .findFirst().get();
    }

    private static List<RacingResult> getMaxResult() {
        return racingCars.entrySet().stream()
                       .max(Comparator.comparing(
                               entry -> entry.getValue().toString().length()))
                       .map(Map.Entry::getValue)
                       .stream().collect(Collectors.toList());
    }

    public void add(RacingCar racingCar, RacingResult racingResult) {
        this.racingCars.put(racingCar, racingResult);
    }

    public void tryRace() {
        racingCars.values().stream()
                .forEach(e -> {
                    if (Utils.getRandomNum() >= 4) {
                        e.forward();
                    }
                });
        printResult();
    }

    private void printResult() {
        racingCars.entrySet().forEach(e -> {
            System.out.println(String.format("%s : %s", e.getKey(), e.getValue()));
        });
        System.out.println();
    }
}
