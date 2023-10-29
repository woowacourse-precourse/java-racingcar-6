package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.view.View;

public class RaceService {
    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_START_RANGE = 0;
    private static final int MOVE_END_RANGE = 9;


    public static void raceRepeatByInput(String input, CarRepository carRepository) {
        int round = Integer.parseInt(input);
        int size = carRepository.size();

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < size; j++) {
                Car car = carRepository.getCar(j);

                int randomDistance = pickRandomNumber();
                boolean canMove = randomDistance >= MOVE_CRITERIA;
                car.move(randomDistance, canMove);

                View.print(car, randomDistance);
            }
            System.out.println();
        }
    }
    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MOVE_START_RANGE, MOVE_END_RANGE);
    }

}
