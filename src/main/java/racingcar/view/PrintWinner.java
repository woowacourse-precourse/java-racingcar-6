package racingcar.view;

import racingcar.util.CheckWinner;

import java.util.ArrayList;
import java.util.List;

public class PrintWinner {
    CheckWinner checkWinner = new CheckWinner();
    public void print(List<String> players, ArrayList<String>[] playerCurrent) {
        List<String> winner = checkWinner.check(players, playerCurrent);

        System.out.print("최종 우승자 : ");
        for (String s : winner) {
            System.out.print(s);
        }
    }
}