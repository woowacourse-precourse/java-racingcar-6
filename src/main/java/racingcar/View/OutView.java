package racingcar.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.Model.Car;

public class OutView {
    public static void printCurrentRoundResult(Map<String, Integer> roundResult) {
        for (Map.Entry<String, Integer> result : roundResult.entrySet()){
            System.out.print(result.getKey() + " : ");
            for(int i=0;i<result.getValue();i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void printWinnerCar(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }

    public static void printWinnerCarList(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }
}
