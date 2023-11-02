package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.RacingCar;
import racingcar.validation.InputValidation;

public class RacingGameService {

    static final int LEAST_RANDOM_NUM = 4;

    InputValidation inputValidation = new InputValidation();

    public List<RacingCar> carNameInput(String userInput) {
        inputValidation.validateCarName(userInput);

        List<String> carNames = Stream.of(userInput.split(","))
                .map(String::trim)
                .toList();

        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar();
            racingCar.initCar(carName);

            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public int racingRoundInput(String userInput) {
        inputValidation.validateRound(userInput);

        return Integer.parseInt(userInput);
    }

    public void race(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = generateRandomNumber();

            if (randomNumber >= LEAST_RANDOM_NUM) {
                racingCar.increaseForwardCount();
            }
        }
    }

    public List<String> getWinner(List<RacingCar> racingCars) {
        List<String> winnerNames = new ArrayList<>();

        int maxForwardCount = getMaxForwardCount(racingCars);

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getForwardCount() == maxForwardCount) {
                winnerNames.add(racingCar.getCarName());
            }
        }

        return winnerNames;
    }

    protected int getMaxForwardCount(List<RacingCar> racingCars) {
        int maxForwardCount = -1;

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getForwardCount() >= maxForwardCount) {
                maxForwardCount = racingCar.getForwardCount();
            }
        }

        return maxForwardCount;
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
