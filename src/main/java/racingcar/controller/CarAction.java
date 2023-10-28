package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.CarObject;

public class CarAction {
    private List<String> carNameList;

    public void carAction() {
        for (int i = 0; i < carNameList.size(); i++) {
            CarMoveJudgment.setCarOnceMoveDistance();
            if(CarMoveJudgment.isNull()) {
                CarObject.nameOf(carNameList.get(i), CarObject.carOnceMove);
            } else {

            }
        }

        CarObject.carsSize = carNameList.size();
    }

    public void inputCarName() {
        String carName = readLine();
        carNameList = CarNameJudgment.splitOf(carName);
    }
}
