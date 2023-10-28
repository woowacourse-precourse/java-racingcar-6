package racingcar.view;

import java.util.List;

public class PrintResult {
    public static void printWinner(List<String> winner_list) {
        System.out.print("최종 우승자 : ");

        System.out.print(winner_list.get(0));
        for (int i = 1; i<winner_list.size(); i++){
            System.out.print(", " + winner_list.get(i));
        }
    }
}