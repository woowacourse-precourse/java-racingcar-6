package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.constant.RaceConstant;
import racingcar.dto.RaceProgressResponse;
import racingcar.dto.WinnerResponse;
import racingcar.message.ValidateErrorMessage;

public class Game {
    private List<String> cars;
    private int raceCount;
    private List<Integer> raceProgress;

    public Game(String cars, String raceCount) {
        List<String> convertedCars = convertToList(cars);
        validate(convertedCars);
        validate(raceCount);
        this.cars = convertedCars;
        this.raceCount = convertToInt(raceCount);
        this.raceProgress = new ArrayList<>(Collections.nCopies(convertedCars.size(), 0));
    }
    public RaceProgressResponse move(List<Integer> randomNumbers){
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) >= RaceConstant.MIN_MOVEMENT_VALUE) {
                int updatedProgress = raceProgress.get(i) + RaceConstant.ONE;
                raceProgress.set(i, updatedProgress);
            }
        }
        return new RaceProgressResponse(cars, raceProgress);
    }
    public WinnerResponse selectWinner() {
        List<String> winner = IntStream.range(0, raceProgress.size())
                .filter(k -> raceProgress.get(k).equals(isMaximum(raceProgress)))
                .mapToObj(cars::get)
                .collect(Collectors.toList());
        return new WinnerResponse(winner);
    }

    private void validate(List<String> cars) {
        cars.stream()
                .filter(car -> car.length() > RaceConstant.MAX_NAME_LENGTH)
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
    private static List<String> convertToList(String cars) {
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    private int convertToInt(String raceCount){
        return Integer.parseInt(raceCount);
    }
    private static int isMaximum(List<Integer> finalResult) {
        return finalResult.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public List<String> getCars() {
        return cars;
    }
    public int getRaceCount() {
        return raceCount;
    }

    public List<Integer> getRaceProgress() {
        return raceProgress;
    }
}