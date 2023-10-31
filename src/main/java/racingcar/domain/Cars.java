package racingcar.domain;

import static racingcar.common.ExceptionMessages.DUPLICATE_CAR_EXCEPTION;
import static racingcar.common.ExceptionMessages.NO_COMMA_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void settingNames(String names) {
        ArrayList<String> nameList = validateAndSendNames(names);
        for(String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getResultOfRound() {
        HashMap<String, Integer> result = new HashMap<>();
        for(Car car : cars) {
            result.put(car.name, car.meter);
        }
        return result;
    }

    public int findMaxScore() {
        return cars.stream()
            .mapToInt(car -> car.meter)
            .max()
            .orElse(Integer.MIN_VALUE);
    }

    public ArrayList<String> findWinners() {
        return cars.stream()
            .filter(car -> car.meter == findMaxScore())
            .map(car -> car.name)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> validateAndSendNames(String names) {
        hasComma(names);

        String[] split = names.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(String name : split) {
            list.add(name.replaceAll(" ", ""));
        }
        validateDuplicateName(list);
        return list;
    }

    private void hasComma(String name) {
        if(!name.contains(",")) {
            throw new IllegalArgumentException(NO_COMMA_EXCEPTION);
        }
    }

    private void validateDuplicateName(ArrayList<String> name) {
        Set<String> nameSet = new HashSet<>(name);
        if(nameSet.size() != name.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_EXCEPTION);
        }
    }
}
