package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public void printCurrentRanking(int[] ranking, ArrayList<String> car) {
        for (int i = 0; i < ranking.length; i++) {
            System.out.printf("%s : ", car.get(i));
            rankingBar(ranking[i]);
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    public void rankingBar(int ranking) { //막대기 출력
        for (int i = 0; i < ranking; i++) {
            System.out.print('-');
        }
    }

    public void printWinner(ArrayList<String> winnerList) {
        String winner = String.join(", ", winnerList);
        System.out.print("최종 우승자 : ");
        System.out.println(winner);

    }
}
