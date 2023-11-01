package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

public class RacingCarService {
    private static final int minimizeRandomNumber = 4;
    private static final int moveForward = 1;
    private static final int minNumber = 0;
    private static final int maxNumber = 9;
    private static final int maxPositionNumber = -1;

    public void playRace(Race race) {
        moveOrStopByRandomNumber(race);
        race.increaseTrialCount();
    }

    private void moveOrStopByRandomNumber(Race race) {
        for (Car car : race.getCars()) {
            if (minimizeRandomNumber <= generateRandomNumber()) {
                car.carMove(moveForward);
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
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
        int max = maxPositionNumber;
        for (Car car : cars) {
            if (max < car.getCarPosition()) {
                max = car.getCarPosition();
            }
        }
        return max;
    }
    
}
