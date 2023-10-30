package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.PrintCurrent;
import racingcar.view.PrintWinner;

import java.util.*;

public class Racing {
    PrintCurrent printCurrent = new PrintCurrent();
    PrintWinner printWinner = new PrintWinner();

    public void play(List<String> players, int trials) {
        ArrayList<String>[] playerCurrent = new ArrayList[players.size()];

        for (int i = 0; i < players.size(); i++) {
            playerCurrent[i] = new ArrayList<String>();
        }

        System.out.println("실행 결과");
        for (int trial = 0; trial < trials; trial++) {
            for (int idx = 0; idx < players.size(); idx++) {
                int random = Randoms.pickNumberInRange(0,9);

                if (random >= 4) {
                    playerCurrent[idx].add("-");
                }
            }
            printCurrent.print(players, playerCurrent);
        }
        printWinner.print(players, playerCurrent);
    }
}
