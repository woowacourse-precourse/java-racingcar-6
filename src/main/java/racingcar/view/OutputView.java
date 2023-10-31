package racingcar.view;

import java.util.List;

public class OutputView {
    public void gameResultMessage(){
        System.out.println("실행 결과");

    }
    public void gameResultStatus(List<String> results){
        for(String result : results){
            System.out.println(result);
        }
        System.out.println();
    }
    public void gameWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
