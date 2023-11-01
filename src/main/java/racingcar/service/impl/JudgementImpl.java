package racingcar.service.impl;

import static racingcar.AppConfig.MINIMUM_GO_NUMBER;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingBoard;
import racingcar.service.Judgement;

public class JudgementImpl implements Judgement {
    @Override
    public boolean isGameSet(int count) {
        return count <= 0;
    }

    @Override
    public ArrayList<String> judgeWinner(RacingBoard racingBoard) {
        int winnerLocationNum = 0;
        ArrayList<String> resultArrayList = new ArrayList<>();
        for (Car car : racingBoard.view()) {
            int carLocationNum = car.getLocation();
            if (winnerLocationNum < carLocationNum) {
                winnerLocationNum = carLocationNum;
            }
        }
        for (int i = 0; i < racingBoard.view().size(); i++) {
            Car car = racingBoard.view().get(i);
            if (winnerLocationNum == car.getLocation()) {
                resultArrayList.add(resultArrayList.size(), car.getName());
            }
        }
        return resultArrayList;
    }

    @Override
    public boolean checkGoCondition(int diceResult) {
        if (diceResult >= MINIMUM_GO_NUMBER) {
            return true;
        }
        return false;
    }
}
