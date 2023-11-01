package view;

import java.util.List;

public class OutputView {
    public void printResult(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        System.out.printf("최종 우승자 : %s", winners);
    }
}
