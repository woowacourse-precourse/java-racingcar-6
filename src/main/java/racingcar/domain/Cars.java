package racingcar.domain;

import static racingcar.common.ExceptionMessages.DUPLICATE_CAR_EXCEPTION;
import static racingcar.common.ExceptionMessages.INVALID_NAME_LENGTH_EXCEPTION;
import static racingcar.common.ExceptionMessages.NO_COMMA_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final ArrayList<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void settingNames(String names) {
        ArrayList<String> nameList = validateAndSendNames(names);
        for(String name : nameList) {
            carList.add(new Car(name));
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public Map<String, Integer> getResultOfRound() {
        HashMap<String, Integer> result = new HashMap<>();
        for(Car car : carList) {
            result.put(car.getName(), car.getMeter());
        }
        return result;
    }

    public int findMaxScore() {
        return carList.stream()
            .mapToInt(Car::getMeter)
            .max()
            .orElse(Integer.MIN_VALUE);
    }

    public ArrayList<String> findWinners() {
        return carList.stream()
            .filter(car -> car.getMeter() == findMaxScore())
            .map(Car::getName)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> validateAndSendNames(String names) {
        hasComma(names);

        String[] split = names.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(String name : split) {
            if(name.isEmpty()) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION);
            }
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
