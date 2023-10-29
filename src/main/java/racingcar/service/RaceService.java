package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import config.CarConfig;
import config.RaceConfig;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.view.View;

public class RaceService {

    public static void runRaceByRound(String input, CarRepository carRepository) {
        int round = Integer.parseInt(input);
        int size = carRepository.size();

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < size; j++) {
                Car car = carRepository.getCar(j);

                int randomDistance = pickRandomNumber();
                boolean canMove = randomDistance >= RaceConfig.MOVABLE_CRITERIA;
                car.move(randomDistance, canMove);

                View.print(car, randomDistance);
            }
            System.out.println();
        }
    }
    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(RaceConfig.MOVE_START_RANGE, RaceConfig.MOVE_END_RANGE);
    }

}
