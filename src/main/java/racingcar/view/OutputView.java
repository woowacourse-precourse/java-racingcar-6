package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;

public class OutputView {
    public static void gameResultOutputPrint(){
        System.out.println("실행 결과");
    }
    public static void gameRoundResultPrint(CarList carList){
        System.out.println(carList.carListMoveCountString());
    }
    public static void gameWinnerPrint(List<String> winners){
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}
