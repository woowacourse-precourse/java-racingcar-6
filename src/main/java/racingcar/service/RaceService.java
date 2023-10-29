package racingcar.service;

import Config.RaceConfig;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.view.View;

public class RaceService {

    public static void raceRepeatByInput(int round, CarRepository carRepository) {
        for (int i = 0; i < round; i++) {
            runRace(carRepository);
            System.out.println();
        }
    }

    private static void runRace(CarRepository carRepository) {
        for (int j = 0; j < carRepository.size(); j++) {
            Car car = carRepository.getCar(j);

            int randomDistance = pickRandomNumber();
            boolean canMove = randomDistance >= RaceConfig.MOVE_CRITERIA;
            car.move(randomDistance, canMove);

            View.print(car, randomDistance);
        }
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(RaceConfig.MOVE_START_RANGE, RaceConfig.MOVE_END_RANGE);
    }

}
