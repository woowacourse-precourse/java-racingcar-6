package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

public class RacingCarService {
    public void playRaceAndIncreaseTrialCount(Race race) {
        for (Car car : race.getCars()) {
            if (4 <= generateRandomNumber()) {
                car.carMove(1);
            }
        }
        race.increaseTrialCount();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
