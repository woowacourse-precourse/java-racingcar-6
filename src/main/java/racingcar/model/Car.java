package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car {
    private final List<String> names;
    private final Map<String, Integer> distance;
    private final List<String> winners;

    private Car(String names) {
        this.names = initNames(names);
        this.distance = initDistance(names);
        this.winners = new ArrayList<>();
    }

    public static Car of(String names) {
        return new Car(names);
    }

    public List<String> getNames() {
        return names;
    }

    public Map<String, Integer> getDistance() {
        return distance;
    }

    public List<String> getWinners() {
        return winners;
    }

    private List<String> initNames(String names) {
        String[] processedNames = names.split(",");
        return Arrays.stream(processedNames)
                .toList();
    }

    private Map<String, Integer> initDistance(String names) {
        String[] processedNames = names.split(",");
        return Arrays.stream(processedNames)
                .collect(Collectors.toMap(name -> name, name -> 0));
    }
}
