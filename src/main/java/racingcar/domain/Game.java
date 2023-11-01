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
    private int raceCount;
    private List<Integer> raceProgress;

    public Game(List<String> cars, int raceCount) {
        validate(cars);
        this.cars = cars;
        this.raceCount = raceCount;
        this.raceProgress = new ArrayList<>(Collections.nCopies(cars.size(), 0));
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