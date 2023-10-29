package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.ValidateErrorMessage;

public class RacingCar {

    private List<String> cars = new ArrayList<>();
    private int RaceCount;
    private List<Integer> raceResult;

    public void updateCars(String cars) {
        List<String> convertedCars = convertToList(cars);
        validate(convertedCars);
        this.cars = convertedCars;
    }

    public void updateRaceCount(String raceCount) {
        validate(raceCount);
        this.RaceCount = convertToInt(raceCount);
    }

    public void updateRaceResult(List<Integer> raceResult) {
        this.raceResult = raceResult;
    }

    private List<String> convertToList(String cars) {
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(List<String> cars) {
        cars.stream()
                .filter(car -> car.length() > 5)
                .findFirst()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ValidateErrorMessage.NAME_LENGTH_ERROR);
                });
    }
    private void validate(String raceCount) {
        try {
            Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.COUNT_TYPE_ERROR);
        }
    }
    private int convertToInt(String raceCount){
        return Integer.parseInt(raceCount);
    }

    public List<String> getCars() {
        return cars;
    }

    public int getRaceCount() {
        return RaceCount;
    }

    public List<Integer> getRaceResult() {
        return raceResult;
    }
}