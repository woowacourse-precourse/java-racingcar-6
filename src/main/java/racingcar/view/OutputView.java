package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Car;

public class OutputView {
    public static void printPlayMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(ArrayList<Car> roundResults) {
        for (Car result : roundResults) {
            System.out.println(result.toString());
        }
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printNewLine(){
        System.out.println();
    }
}
