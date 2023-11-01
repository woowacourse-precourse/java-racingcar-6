package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.view.PrintCurrent;
import racingcar.view.PrintWinner;

import java.util.*;

public class Racing {
    PrintCurrent printCurrent = new PrintCurrent();
    PrintWinner printWinner = new PrintWinner();
    RandomNumber randomNumber = new RandomNumber();

    public void play(List<String> players, int trials) {
        ArrayList<String>[] playerCurrent = new ArrayList[players.size()];

        for (int i = 0; i < players.size(); i++) {
            playerCurrent[i] = new ArrayList<String>();
        }

        System.out.println("실행 결과");
        for (int trial = 0; trial < trials; trial++) {
            for (int idx = 0; idx < players.size(); idx++) {
                int random = randomNumber.get();

                if (random >= 4) {
                    playerCurrent[idx].add("-");
                }
            }
            printCurrent.print(players, playerCurrent);
        }
        printWinner.print(players, playerCurrent);
    }
}