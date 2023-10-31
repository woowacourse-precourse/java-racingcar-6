package racingcar.utility;

import static racingcar.constant.GameConstants.MAX_NUM;
import static racingcar.constant.GameConstants.MIN_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGameUtility {
    private CarRaceGameUtility(){}

    public static void executeCarRaceGameOneRound() {
        for (Car car : GameManager.getCarImplList()) {
            if (car.decideToMove(randomNumberGenerator())) {
                car.forwardOneBlock();
            }
            CarRaceGameView.printOneRoundResult(car.getCarName(), car.getAdvanceNumber());
        }
        CarRaceGameView.printBlackLine();
    }

    public static int randomNumberGenerator() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        Validator.randomNumberRange(randomNumber);
        return randomNumber;
    }

    public static List<String> findWinner(List<Car> carImplList) {
        int max = 0;
        List<String> winnerList = new ArrayList<String>();
        for (Car car : carImplList) {
            int advanceNumber = car.getAdvanceNumber();
            if (max == advanceNumber) {
                winnerList.add(car.getCarName());
            }
            if (max < advanceNumber) {
                max = advanceNumber;
                winnerList.clear();
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
    }
}

