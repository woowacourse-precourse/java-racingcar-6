package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.constant.RaceConstant;
import racingcar.dto.RaceResultResponse;

public class Game {
    RandomNumberGenerator generator = new RandomNumberGenerator();

    public RaceResultResponse updateRaceResult(RacingCar racingCar){
        List<Integer> raceResult = generateRaceResult(racingCar);
        racingCar.updateRaceResult(raceResult);
        return new RaceResultResponse(racingCar.getCars(), racingCar.getRaceResult());
    }

    private List<Integer> generateRaceResult(RacingCar racingCar) {
        List<Integer> randomNumbers = getRandomNumbers(racingCar.getCars().size());
        List<Integer> raceResult = getRaceResult(racingCar);
        for (int i = RaceConstant.START_INDEX; i < randomNumbers.size(); i++) {
            move(randomNumbers, raceResult, i);
        }
        return raceResult;
    }

    private static void move(List<Integer> randomNumbers, List<Integer> raceResult, int i) {
        if (randomNumbers.get(i) >= RaceConstant.MIN_MOVEMENT_VALUE) {
            int updatedResult = raceResult.get(i) + RaceConstant.MOVE;
            raceResult.set(i, updatedResult);
        }
    }

    private static List<Integer> getRaceResult(RacingCar racingCar) {
        List<Integer> raceResult = racingCar.getRaceResult();
        if (raceResult == null) {
            raceResult = new ArrayList<>(Collections.nCopies(racingCar.getCars().size(), 0));
        }
        return raceResult;
    }

    private List<Integer> getRandomNumbers(int carsCount) {
        return generator.generateRandomNumbers(carsCount);
    }
}