package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

public class RacingCarService {

    public void playRace(Race race) {
        moveOrStopByRandomNumber(race);
        race.increaseTrialCount();
    }

    private void moveOrStopByRandomNumber(Race race) {
        for (Car car : race.getCars()) {
            if (4 <= generateRandomNumber()) {
                car.carMove(1);
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> selectWinners(Race race) {
        List<Car> cars = race.getCars();
        int maxPosition = decideMaxPosition(cars);
        return decideMaxPositionCars(cars, maxPosition);
    }

    private List<String> decideMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarPosition() == maxPosition) {
                carNames.add(car.getCarName());
            }
        }
        return carNames;
    }

    private int decideMaxPosition(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            if (max < car.getCarPosition()) {
                max = car.getCarPosition();
            }
        }
        return max;
    }
}
