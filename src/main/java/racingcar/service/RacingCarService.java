package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {
    private static final String DELIMITER = ",";
    private static final int CONDITION_NUMBER = 4;
    private static final int MOVE = 1;
    private final List<RacingCar> racingCars;

    public RacingCarService() {
        racingCars = new ArrayList<>();
    }

    public String[] splitRacingCarsByComma(String racingCars) {
        return racingCars.split(DELIMITER);
    }

    public void saveRacingCars(String[] carNames) {
        racingCars.addAll(
                Arrays.stream(carNames)
                        .map(RacingCar::new)
                        .toList());
    }

    public void playOneRacing() {
        for (RacingCar racingCar : racingCars) {
            proceedOneRacingCar(racingCar);
        }
    }

    private void proceedOneRacingCar(RacingCar racingCar) {
        int randomNumber = RandomUtil.getRandomNumber();
        if (canMove(randomNumber)) {
            racingCar.plusMove(MOVE);
        }
    }

    private boolean canMove(int number) {
        return number >= CONDITION_NUMBER;
    }
}
