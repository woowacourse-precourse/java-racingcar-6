package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarObject;

public class CarAction {
    private List<String> carNameList;
    private ArrayList<Integer> carMoveList;

    public void carAction() {
        for (int i = 0; i < carNameList.size(); i++) {
            CarMoveJudgment.setCarOnceMoveDistance();
            if (CarMoveJudgment.isNull()) {
                CarObject.nameOf(carNameList.get(i), CarObject.carOnceMove);
            } else {
                carMoveList.add(CarObject.carOnceMove);
            }
        }

        if (CarMoveJudgment.isNull()) {
            CarObject.carsSize = carNameList.size();
            return;
        }

        CarObject.carsSize = carNameList.size();
        CarObject.updateCarDistance(carMoveList);
        carMoveList.clear();
    }

    public void inputCarName() {
        String carName = readLine();
        carNameList = CarNameJudgment.splitOf(carName);
    }

    public void inputEpoch() {
        String epoch = readLine();
        CarObject.epoch = Integer.parseInt(epoch);
    }
}
