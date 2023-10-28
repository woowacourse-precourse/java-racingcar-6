package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashMap;
import java.util.List;
import racingcar.model.CarObject;

public class CarAction {
    private List<String> carNameList;
    private List<Integer> carMoveSizeList;
    private HashMap<String, Integer> actionResult;

    public void carAction() {
        if (carNameList.size() != carMoveSizeList.size()) {
            new IllegalArgumentException();
            return;
        }

        for (int i = 0; i < carNameList.size(); i++) {
            actionResult.put(carNameList.get(i), carMoveSizeList.get(i));
        }

        CarObject.nameOf(actionResult);
    }

    public void inputCarName() {
        String carName = readLine();
        carNameList = CarNameJudgment.splitOf(carName);
    }

    public void selectCarCondition() {
        for (int i = 0; i < carNameList.size(); i++) {
            carMoveSizeList.add(CarMoveJudgment.result());
        }
    }
}
