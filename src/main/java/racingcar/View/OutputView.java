package racingcar.View;

import java.util.List;

public class OutputView {
    private static final String TRIAL_RESULT = "\n실행 결과";
    private static final String RESULT_SETING = "%s : %s\n";
    private static final String FINAL_WINNER = "최종 우승자 : %s\n";
    private static final String COMMA = ", ";


    public void printResultStart(){
        System.out.println(TRIAL_RESULT);
    }

    public void printRacingResult(String name, String icon){
        System.out.printf(RESULT_SETING, name, icon);
    }

    public void printWinner(List<String> winners){
        System.out.printf(FINAL_WINNER, String.join(COMMA, winners));
    }
}
