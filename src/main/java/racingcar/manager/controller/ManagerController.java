package racingcar.manager.controller;

import java.util.HashMap;
import java.util.Map;
import racingcar.car.controller.CarController;
import racingcar.manager.view.ManagerView;
import racingcar.user.controller.UserController;

public class ManagerController {

    ManagerView managerView = new ManagerView();

    public void run(){
        CarController carController = new CarController();
        UserController userController = new UserController();
    }

    public void printTryResult(HashMap<String, Integer> cars){
        for(Map.Entry<String, Integer> entry : cars.entrySet()){
            String carName = entry.getKey();
            Integer moveCount = entry.getValue();

            String totalMoveCount = managerView.getTotalMoveCount(moveCount);
            managerView.printMovingMessage(carName,totalMoveCount);
        }
    }
}
