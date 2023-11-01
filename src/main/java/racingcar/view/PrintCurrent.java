package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class PrintCurrent {
    public void print(List<String> players, ArrayList<String>[] playerCurrent) {


        for(int idx = 0; idx < players.size(); idx++) {
            System.out.print(players.get(idx) + " : ");

            for (int i = 0; i < playerCurrent[idx].size(); i++) {
                System.out.print(playerCurrent[idx].get(i));
            }
            System.out.println();
        }
        System.out.println();
    }
}