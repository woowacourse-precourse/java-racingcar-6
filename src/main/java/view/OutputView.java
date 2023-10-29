package view;

import java.util.List;

public class OutputView {

    public static final String PRINT_FINAL_RESULT = "최종 우승자 : ";

    public void printFinalResult(List<String> winners) {
        System.out.print(PRINT_FINAL_RESULT);
        for(String winner : winners) {
            System.out.print(winner);
        }
    }
}
