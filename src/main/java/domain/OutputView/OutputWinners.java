package domain.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputWinners {
    public static void printWinners(List<String> winners) {
        String totalWinners = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", totalWinners);
    }
}
