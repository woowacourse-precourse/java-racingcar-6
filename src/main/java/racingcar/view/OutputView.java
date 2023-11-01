package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void outputCarMoveDistance(String carName, int stepDistance) {
        System.out.print(carName + " : ");
        for (int i = 0; i < stepDistance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void informFinalWinner(List<String> carName) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", carName);
        System.out.println(result);
    }
}
