package racingcar.domain;

import java.util.LinkedHashMap;
import racingcar.utils.Utils;

public class RacingCars {
    private final static LinkedHashMap<RacingCar, RacingResult> racingCars = new LinkedHashMap<>();

    public void add(RacingCar racingCar, RacingResult racingResult) {
        this.racingCars.put(racingCar, racingResult);
    }

    public boolean lengthCheck() {
        if (!racingCars.keySet().stream().allMatch(e -> Utils.wordLengthCheck(e.toString()))) {
            return false;
        }
        return true;
    }

    public void tryRace() {
        racingCars.values().stream()
                .forEach(e -> {
                    if (Utils.getRandomNum() > 4) {
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
