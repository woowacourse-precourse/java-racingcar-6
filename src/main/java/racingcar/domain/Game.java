package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.constant.RaceConstant;

public class Game {

    public List<Integer> updateRaceResult(List<Integer> randomNumbers, RacingCar racingCar){
        List<Integer> raceResult = getRaceResult(racingCar);
        for (int i = RaceConstant.START_INDEX; i < randomNumbers.size(); i++) {
            move(randomNumbers, raceResult, i);
        }
        racingCar.updateRaceResult(raceResult);
        return raceResult;
    }

    private static void move(List<Integer> randomNumbers, List<Integer> raceResult, int i) {
        if (randomNumbers.get(i) >= RaceConstant.MIN_MOVEMENT_VALUE) {
            int updatedResult = raceResult.get(i) + RaceConstant.ONE;
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
}