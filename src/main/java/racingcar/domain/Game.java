package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RaceConstant;

public class Game {
    RandomNumberGenerator generator = new RandomNumberGenerator();
    public List<Boolean> generateRaceResult(int carsCount){
        List<Integer> randomNumbers = getRandomNumbers(carsCount);
        return randomNumbers.stream()
                .map(randomNumber -> randomNumber >= RaceConstant.MIN_MOVEMENT_VALUE)
                .collect(Collectors.toList());
    }

    private List<Integer> getRandomNumbers(int carsCount) {
        return generator.generateRandomNumbers(carsCount);
    }
}
