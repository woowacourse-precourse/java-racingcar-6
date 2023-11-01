package racingcar.domain;

import java.util.ArrayList;
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
    private List<Integer> raceProgress;

    public Game(List<String> cars) {
        validate(cars);
        this.cars = cars;
        this.raceProgress = new ArrayList<>(Collections.nCopies(cars.size(), 0));
    }
    private void validate(List<String> cars) {
        cars.stream()
                .filter(car -> car.length() > RaceConstant.MAX_NAME_LENGTH)
                .findFirst()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ValidateErrorMessage.NAME_LENGTH_ERROR);
                });
    }
    public RaceProgressResponse move(List<Integer> randomNumbers){
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) >= RaceConstant.MIN_MOVEMENT_VALUE) {
                int updatedProgress = raceProgress.get(i) + RaceConstant.PROGRESS_DISTANCE;
                raceProgress.set(i, updatedProgress);
            }
        }
        return new RaceProgressResponse(cars, raceProgress);
    }
    public WinnerResponse selectWinner() {
        int maxDistance = getMaxDistance(raceProgress);
        List<String> winner = IntStream.range(0, raceProgress.size())
                .filter(k -> raceProgress.get(k).equals(maxDistance))
                .mapToObj(cars::get)
                .collect(Collectors.toList());
        return new WinnerResponse(winner);
    }
    private int getMaxDistance(List<Integer> finalResult) {
        return finalResult.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}