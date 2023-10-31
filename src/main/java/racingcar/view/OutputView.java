package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void outputCarMoveResult(Map<String, Integer> carData) {
        System.out.print("실행 결과\n");

        carData.forEach((key, value) -> {
            int intValue = value;
            System.out.print(key + " : " + "-".repeat(intValue)+"\n");
        });

        System.out.println();
    }

    public static void outputWinnerResult(List<String> winners) {
        System.out.print("최종 우승자 : ");

        System.out.print(String.join(",", winners));
        }
}
