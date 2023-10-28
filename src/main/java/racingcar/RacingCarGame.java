package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    final int trial;
    final List<RacingCar> cars;

    public RacingCarGame(int trial, String[] names) {
        checkTrial(trial);
        this.trial = trial;
        cars = Arrays.stream(names)
                .map(RacingCar::new)
                .collect(toList());
    }

    private static void checkTrial(int trial){
        if(trial <= 0)
            throw new IllegalArgumentException("시도횟수는 1 이상의 값이여야 합니다.");
    }


}
