package racingcar.View;

import java.util.List;

public class OutputView {
    
    public static void printCurrentStatus(List<String> carNames, List<Integer> carpositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carpositions.get(i)));
        }
        System.out.println();
    }

    public static void printStart() {
		System.out.println("\n실행 결과");
	}
}
