package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.util.Constants;

public class OutputView {
    private static void myRacingView(String carName, int moveCount) {
        StringBuilder currentMoveMessage = new StringBuilder();
        currentMoveMessage.append(carName);
        currentMoveMessage.append(" : ");
        for (int count = 0; count < moveCount; count++) {
            currentMoveMessage.append(Constants.STEP);
        }
        System.out.println(currentMoveMessage);
    }

    public static void currentRacingView(CarList carList) {
        for (Car car : carList.getCarList()) {
            myRacingView(car.getCarName(), car.getMoveCount());
        }
        System.out.println();
    }

    public static void winnerView(List<String> winnerList) {
        StringBuilder winnerMessage = new StringBuilder();
        if (winnerList.size() == 1) {
            winnerMessage.append(Constants.WINNER_NOTICE);
            winnerMessage.append(winnerList.get(0));
            System.out.println(winnerMessage);
            return;
        }
        winnerMessage.append(Constants.WINNER_NOTICE);
        for (int count = 0; count < winnerList.size(); count++) {
            winnerMessage.append(winnerList.get(count));
            if (count < winnerList.size() - 1) {
                winnerMessage.append(Constants.COMMA);
            }
        }
        System.out.println(winnerMessage);

    }
}
