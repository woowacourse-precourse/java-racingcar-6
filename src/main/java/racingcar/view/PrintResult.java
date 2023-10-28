package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class PrintResult {
    public static void printMove(List<String> car_list, StringBuilder[] move_result){
        for (int i = 0; i<car_list.size(); i++){
            System.out.println(car_list.get(i) + " : " + move_result[i]);
        }
    }

    public static void printWinner(List<String> car_list, StringBuilder[] move_result) {
        List<String> winner = selectWinner(car_list, move_result);

        System.out.print("최종 우승자 : " + winner.get(0));
        for (int i = 1; i<winner.size(); i++){
            System.out.print(", " + winner.get(i));
        }
    }
    public static List<String> selectWinner(List<String> car_list, StringBuilder[] move_result){
        List<String> winner = new ArrayList<>();
        int max_move = 0;

        for (StringBuilder move : move_result) {
            int numberOfMove = move.length();
            if (numberOfMove >= max_move) {
                max_move = numberOfMove;
            }
        }
        for (int i = 0; i < move_result.length; i++) {
            if(move_result[i].length() == max_move){
                winner.add(car_list.get(i));
            }
        }
        return winner;
    }
}
