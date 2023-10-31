package racingcar.view;

import java.util.List;

public class GameOutputView {

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printScore(String name, int position) {
       System.out.println(name + " : " + "-".repeat(position));
    }

    public void printOneLine() {
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner.size(); i++) {
            System.out.print(winner.get(i));
        }
    }
}
