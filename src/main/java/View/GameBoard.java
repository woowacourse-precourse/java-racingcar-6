package View;

import java.util.List;

public class GameBoard {

    public void showGameResult(String car, int move) {
        System.out.print(car + " : ");
        for(int i=0; i<move; i++)
            System.out.print("-");
        System.out.println();
    }

    public void showWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        String win = String.join(",", winner);
        System.out.println(win);
    }
}
