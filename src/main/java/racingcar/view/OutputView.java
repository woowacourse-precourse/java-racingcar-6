package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printProgressStmt() {
        System.out.println("\n실행 결과");
    }

    public static void printOneTurnResult(List<String> cars, List<Integer> carPos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i) + " : ");
            Integer distance = carPos.get(i);
            for (int j = 0; j < distance; j++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
