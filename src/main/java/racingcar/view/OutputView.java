package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

public class OutputView {
    public static void gameRoundResultPrint(CarList carList){
        System.out.println(carList.carListMoveCountString());
    }
}
