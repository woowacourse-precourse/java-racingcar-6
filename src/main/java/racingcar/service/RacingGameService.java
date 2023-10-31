package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.validation.InputValidation;
import racingcar.view.SystemMessage;

public class RacingGameService {

    SystemMessage systemMessage = new SystemMessage();

    InputValidation inputValidation = new InputValidation();

    public List<RacingCar> carNameInput() {
        systemMessage.printRequestInputMessage();

        String input = readLine();

        List<String> carNames = List.of(input.split(","));
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar();
            racingCar.initCar(carName);

            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public int racingRoundInput() {
        systemMessage.printRequestTryCountMessage();

        String input = readLine();

        inputValidation.validateRound(input);

        return Integer.parseInt(input);
    }

    public void race(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = generateRandomNumber();

            if (randomNumber >= 4) {
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
