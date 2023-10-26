package app.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class play {

    private Map<String, Integer> race;

    public play(String raceList) {
        this.race = Arrays.stream(raceList.split(","))
                .collect(Collectors.toMap(key -> key, value -> 0));
    }

    public Map<String, Integer> getRace() {
        return race;
    }

    public void play() {
        for (String carName : race.keySet()) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            if (randomNum >= 4) {
                race.put(carName, race.getOrDefault(carName, 0) + 1);
            }
        }
    }


    public void printResult() {
        for (String car : race.keySet()) {
            System.out.println(car + " : " + "-".repeat(race.get(car)));
        }
        System.out.println();
    }
}
