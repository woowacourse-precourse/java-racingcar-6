package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

public class OutputView {
    public static void gameResultOutputPrint(){
        System.out.println("실행 결과");
    }
    public static void gameRoundResultPrint(CarList carList){
        System.out.println(carList.carListMoveCountString());
    }
}
