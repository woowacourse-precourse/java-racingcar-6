package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class UserOutput {

    public static void printResultStart() {
        System.out.println("\n실행 결과");
    }
    public static void printRoundResult(List<String> carNames, List<Integer> roundResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < carNames.size(); index++) {
            int distance = roundResult.get(index);
            stringBuilder.append(carNames.get(index));
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(distance));
            stringBuilder.append("\n");
        }
        String result = stringBuilder.toString();
        System.out.println(result);
    }

}
