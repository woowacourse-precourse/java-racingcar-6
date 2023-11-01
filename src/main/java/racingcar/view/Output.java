package racingcar.view;

import java.util.List;

public class Output {
    public void RunResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public void printEnter() {
        System.out.print("\n");
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner.size(); i++) {
            System.out.print(winner.get(i));
        }
    }
}
