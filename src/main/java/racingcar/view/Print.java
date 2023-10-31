package racingcar.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.constant.ConstPrint;

public class Print {
    public static void showUser(ConstPrint constPrint){
        System.out.println(constPrint.getConstPrint());
    }

    public static void showGameResult(List<Car>parkingLot){
        for(int i = 0; i< parkingLot.size();i++){
            System.out.println(parkingLot.get(i).getCarName() + " : " + parkingLot.get(i).getDistance());
        }
        System.out.println();
    }

    public static void showGameWinner(ConstPrint constPrint, List<String>winners){
        System.out.println(constPrint.getConstPrint() + " : " + String.join(", ",winners));
    }
}
