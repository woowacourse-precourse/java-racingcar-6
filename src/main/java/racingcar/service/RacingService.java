package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingService {
    public String startRace(int count, List<RacingCar> racingCars) {
        String result = "";
        for (int round = 0; round < count; round++) {
            result += executeRound(racingCars) + "\n";
        }
        return result;
    }
    
    public String executeRound(List<RacingCar> racingCars) {
        String output = "";
        for (RacingCar racingCar : racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCar.move(randomNumber);
            output += racingCar.name + " : " + "-".repeat(racingCar.count) + "\n";
        }
        return output;
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
