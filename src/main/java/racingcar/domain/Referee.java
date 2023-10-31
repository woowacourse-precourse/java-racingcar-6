package racingcar.domain;

import java.util.List;

public class Referee {
    static SystemMessage systemMessage = new SystemMessage();
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
        systemMessage.printWinnerMessage();
        System.out.println(winners);
    }
}
