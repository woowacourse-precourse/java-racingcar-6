package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.utils.RandomUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingService {
    private static final String DELIMITER = ",";
    private static final int CONDITION_NUMBER = 4;
    private static final int MOVE = 1;
    private final List<RacingCar> racingCars;

    public RacingService() {
        racingCars = new ArrayList<>();
    }

    public String[] splitRacingCarsByComma(String racingCars) {
        String[] carList = racingCars.split(DELIMITER);
        return carList;
    }

    public void saveRacingCars(String[] carNames) {
        racingCars.addAll(
                Arrays.stream(carNames)
                        .map(RacingCar::new)
                        .toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
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

    public List<String> getWinnerNames() {
        int maxMove = getMaxMove();
        return racingCars.stream()
                .filter(car -> car.getMove() == maxMove)
                .map(RacingCar::getName)
                .toList();
    }

    private int getMaxMove() {
        return racingCars.stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElse(0);
    }
}
