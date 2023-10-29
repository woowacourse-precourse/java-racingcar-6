package racingcar.view;

import racingcar.controller.CarAction;
import racingcar.model.CarObject;
import racingcar.model.Message;

public class CarRaceStart {
    public static void exe() {
        CarAction car = new CarAction();

        System.out.println(Message.INPUT_CAR_QUESTION);
        car.inputCarName();

        System.out.println(Message.INPUT_EPOCH_QUESTION);
        car.inputEpoch();

        for(int i = 0; i < CarObject.epoch; i++) {
            car.carAction();
        }
    }
}
