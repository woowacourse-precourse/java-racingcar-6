package racingcar.domain;

import static racingcar.common.Validator.hasDelimiter;
import static racingcar.common.Validator.hasDuplicates;
import static racingcar.common.Validator.validateNameLength;
import static racingcar.common.Validator.validateNamesInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final ArrayList<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void settingNames(String names) {
        validateBeforeAddToList(names);
        ArrayList<String> nameList = validateAddingList(names);
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
            car.saveInformationToMap(result);
        }
        return result;
    }

    public int findMaxScore() {
        return carList.stream()
            .mapToInt(Car::getMeter)
            .max()
            .orElse(Integer.MIN_VALUE);
    }

    public ArrayList<String> findWinners(int maxScore) {
        return carList.stream()
            .filter(car -> car.hasMaxScore(maxScore))
            .map(Car::getName)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> validateAddingList(String names) {
        ArrayList<String> list = validNamesList(names);
        hasDuplicates(list);
        return list;
    }

    private void validateBeforeAddToList(String names) {
        hasDelimiter(names);
        validateNamesInput(names);
    }

    private ArrayList<String> validNamesList(String names) {
        ArrayList<String> list = new ArrayList<>();
        for (String name : names.split(",")) {
            String cleanedName = name.replaceAll(" ", "");
            validateNameLength(cleanedName);
            list.add(cleanedName);
        }
        return list;
    }
}
