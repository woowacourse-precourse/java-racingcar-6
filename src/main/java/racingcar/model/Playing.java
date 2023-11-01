package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.utils.RandomNumberGenerator;

public class Playing {
    private static final String VALIDATE_TRY_COUNT = "시도 회수는 1 이상이어야 합니다.";
    private static final String HASH = ", ";

    private final RacingCars racingCars;
    private final RandomNumberGenerator randomNumberGenerator;
    private int tryCount;

    public Playing(List<String> racingCarNames, int tryCount) {
        validateTryCount(tryCount);
        this.racingCars = new RacingCars(racingCarNames);
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.tryCount = tryCount;
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < 1) throw new IllegalArgumentException(VALIDATE_TRY_COUNT);
    }

    public void playOneGame() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            randomNumbers.add(randomNumberGenerator.randomNumberGenerate());
        }
        racingCars.play(randomNumbers);
    }

    public void play() {
        playOneGame();
        tryCount--;
    }

    public boolean playStatus() {
        return this.tryCount != 0;
    }

    public List<String> getRacingCarsStatus() {
        return this.racingCars.getRacingCarsStatus();
    }

    public String getResult() {
        List<String> winners = racingCars.getWinners();
        return String.join(HASH, winners);
    }
    
}
