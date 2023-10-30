package racingcar.domain;

import java.util.List;

public class Referee {
    final String SYSTEM_MESSAGE = "최종 우승자 : ";
    final String SEPARATE_WINNER = ",";
    public void printWinner(List<String> winner){
        String winners  = new String();
        int totalWinnerNumber = winner.size();
        for(String name : winner){
            winners += name;
            if(totalWinnerNumber > 1){
                winners += SEPARATE_WINNER;
                totalWinnerNumber--;
            }
        }
        System.out.print(SYSTEM_MESSAGE);
        System.out.println(winners);
    }
}
