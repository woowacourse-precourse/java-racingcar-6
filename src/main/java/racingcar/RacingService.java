package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private final List<RacingCar> racingCars;
    private final int rounds;
    private final IOHandler ioHandler = new IOHandler();

    public RacingService(List<RacingCar> cars, int count) {
        racingCars = cars;
        rounds = count;
    }

    public void startRace() {
        for (int round = 0; round < rounds; round++) {
            executeRound();
        }
    }

    private void executeRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.execute();
            ioHandler.printComment(racingCar.name + " : " + "-".repeat(racingCar.count));
        }
        ioHandler.printComment("");
    }
    
    public List<String> getWinnerNames() {
        List<String> winners = new ArrayList<>();
        int maxCount = getMaxCount();

        for (RacingCar car : racingCars) {
            if (car.count == maxCount) {
                winners.add(car.name);
            }
        }

        return winners;
    }

    private int getMaxCount() {
        int maxCount = 0;
        for (RacingCar car : racingCars) {
            maxCount = Math.max(maxCount, car.count);
        }
        return maxCount;
    }
}
