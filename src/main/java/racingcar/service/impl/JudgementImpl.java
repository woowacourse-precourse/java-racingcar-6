package racingcar.service.impl;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingBoard;
import racingcar.service.Judgement;

public class JudgementImpl implements Judgement {
    @Override
    public boolean isGameSet(int count) {
        if (count <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> judgeWinner(RacingBoard racingBoard) {
        int maxLocationNum = 0;
        ArrayList<String> resultArrayList = new ArrayList<>();
        for (Car car : racingBoard.view()) {
            int carLocationNum = car.getLocation();
            if (maxLocationNum < carLocationNum) {
                maxLocationNum = carLocationNum;
            }
        }
        for (int i = 0; i < racingBoard.view().size(); i++) {
            Car car = racingBoard.view().get(i);
            if(maxLocationNum == car.getLocation()) {
                resultArrayList.add(resultArrayList.size(), car.getName());
            }
        }
        return resultArrayList;
    }
}
