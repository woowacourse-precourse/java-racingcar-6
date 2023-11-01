package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.io.IOHandler;

public class RacingService {
    private final IOHandler ioHandler = new IOHandler();

    public void startRace(int count, List<RacingCar> racingCars) {
        for (int round = 0; round < count; round++) {
            executeRound(racingCars);
        }
    }

    private void executeRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCar.move(randomNumber);
            ioHandler.printComment(racingCar.name + " : " + "-".repeat(racingCar.count));
        }
        ioHandler.printComment("");
    }

    public List<String> getWinnerNames(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxCount = getMaxCount(racingCars);

        for (RacingCar car : racingCars) {
            if (car.count == maxCount) {
                winners.add(car.name);
            }
        }

        return winners;
    }

    private int getMaxCount(List<RacingCar> racingCars) {
        int maxCount = 0;
        for (RacingCar car : racingCars) {
            maxCount = Math.max(maxCount, car.count);
        }
        return maxCount;
    }
}
