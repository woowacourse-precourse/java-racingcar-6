package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Track {
    private final List<RacingCar> racingCars;
    private final int RANDOM_START = 0;
    private final int RANDOM_END = 9;

    public Track(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public Map<String, Integer> round() {
        Map<String, Integer> roundResult = new HashMap<>();
        racingCars.forEach(racingCar -> {
            int random = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
            racingCar.moveBy(random);
            roundResult.put(racingCar.getName(), racingCar.getPosition());
        });
        return roundResult;
    }

    public List<String> selectWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        racingCars.stream().filter(racingCar -> racingCar.getPosition() == maxPosition)
                .forEach(winner -> {
                    winners.add(winner.getName());
                });
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition());
        }
        return maxPosition;
    }
}
