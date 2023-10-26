package app.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {

    private Map<String, Integer> race;

    public Race(String raceList) {
        this.race = Arrays.stream(raceList.split(",")).collect(Collectors.toMap(key -> key, value -> 0));
    }

    public void play() {
        for (String carName : race.keySet()) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            if (randomNum >= 4) {
                race.put(carName, race.getOrDefault(carName, 0) + 1);
            }
        }
    }


    public void printPlay() {
        for (String car : race.keySet()) {
            System.out.println(car + " : " + "-".repeat(race.get(car)));
        }
        System.out.println();
    }

    public int getMaxNum() {
        return race.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getValue();
    }

    public String[] getWinner(int max) {
        return race.entrySet()
                .stream()
                .filter(x -> x.getValue() == max)
                .map(x -> x.getKey())
                .toArray(String[]::new);
    }
}
