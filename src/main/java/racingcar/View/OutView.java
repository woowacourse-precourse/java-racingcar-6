package racingcar.View;

import java.util.List;

public class OutView {
    public static void printCurrentRoundResult(List<String> roundResult) {
        for (String result : roundResult) {
            System.out.println(result);
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