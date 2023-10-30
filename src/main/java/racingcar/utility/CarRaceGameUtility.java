package racingcar.utility;

import static racingcar.constant.GameConstants.EXECUTION_RESULT;
import static racingcar.constant.GameConstants.MAX_NUM;
import static racingcar.constant.GameConstants.MIN_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.view.CarRaceGameView;

public class CarRaceGameUtility {

    private CarRaceGameUtility(){}



    public static void startCarRaceGameOneRound() {
        for (Car car : GameManager.getCarImplList()) {
            decideToMove(car);
            CarRaceGameView.tryForwardResultView(car.getCarName(), car.getAdvanceNumber());
        }
        CarRaceGameView.newRoundRefreshView();
    }

    public static int randomNumberGenerator() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        return randomNumber;
    }

    public static void decideToMove(Car car) {
        if (4 >= randomNumberGenerator()) {
            car.forwardOneBlock();
        }
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

