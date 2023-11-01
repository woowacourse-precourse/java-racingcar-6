package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

public class RacingCarService {
    public List<String> playAndSelectWinners(Race race) {
        List<String> winners = new ArrayList<>();

        for (Car car : race.getCars()) {
            if (4 <= generateRandomNumber()) {
                car.carMove(1);
            }
        }

        race.increaseTrialCount();

        int maxPosition = -1;
        for (Car car : race.getCars()) {
            if (maxPosition < car.getCarPosition()) {
                maxPosition = car.getCarPosition();
            }
        }

        for (Car car : race.getCars()) {
            if (car.getCarPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
