package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public void printCurrentRanking(int[] ranking, ArrayList<String> car){
        for(int i = 0; i < ranking.length; i++){
            System.out.printf("%s : ",car.get(i));
            rankingBar(ranking[i]);
            System.out.print("\n");
        }
    }
    public void rankingBar(int ranking){ //막대기 출력
        for(int i = 0; i < ranking; i++){
            System.out.print('-');
        }
    }
}
