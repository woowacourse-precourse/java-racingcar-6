package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintOutput {
    public static void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printMove(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printAllMove(HashMap<String, Integer> car_list) {
        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            System.out.print(item.getKey() + " : ");
            printMove(item.getValue());
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner_list) {
        System.out.print("최종 우승자 : ");

        System.out.print(winner_list.get(0));
        for (int i = 1; i < winner_list.size(); i++) {
            System.out.print(", " + winner_list.get(i));
        }
    }
}