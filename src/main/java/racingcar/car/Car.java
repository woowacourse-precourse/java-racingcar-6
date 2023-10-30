package racingcar.car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.exception.ExceptionMessage;
import racingcar.utils.Utils;

public class Car {
    LinkedHashMap<String, Integer> namesMap;


    public List<String> getNames() {
        return namesMap.keySet().stream().toList();
    }

    public int getValue(String name) {
        return namesMap.get(name);
    }

    public Collection<Integer> getValues() {
        return namesMap.values();
    }

    public void createName(String carName) {
        this.namesMap = createNameMap(splitToName(carName));
    }

    private LinkedHashMap<String, Integer> createNameMap(List<String> names) {
        LinkedHashMap<String, Integer> namesMap = new LinkedHashMap<>();
        for (String name : names) {
            namesMap.put(name, 0);
        }
        return namesMap;
    }

    private void validateName(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.NAME_OF_RANGE);
            }
        }
    }

    private List<String> splitToName(String carName) {
        List<String> names = List.of(carName.split(","));
        validateName(names);
        return names;
    }

    private boolean moveToGo() {
        int result = Utils.randomNumberGenerator();
        return result >= 4;
    }

    public void driving(List<String> names) {
        for (String name : names) {
            if (moveToGo()) {
                changeValue(name);
            }
        }
    }

    private void changeValue(String name) {
        this.namesMap.put(name, this.namesMap.get(name) + 1);
    }

    public List<String> winnerList() {
        List<String> winners = new ArrayList<>();
        List<String> names = getNames();
        int max = Collections.max(getValues());

        for (String name : names) {
            if (findWinner(name, max)) {
                winners.add(name);
            }
        }
        return winners;
    }

    private boolean findWinner(String name, int max) {
        return (getValue(name) >= max);
    }
}
