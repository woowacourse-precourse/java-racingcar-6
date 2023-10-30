package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Movecar {
    public void print(int usercount, List<String> carname) {
        int[] carmove = new int[carname.size()];
        System.out.println("\n실행 결과");
        for (int i = 0; i < usercount; i++) {
            go_or_stop(carname, carmove);
        }
        List<String> winneruser = winner(carname, carmove);
        System.out.printf("최종 우승자 : %s", winneruser.get(0));
        for (int i = 1; i < winneruser.size(); i++) {
            System.out.printf(", %s", winneruser.get(i));
        }
    }

    public void go_or_stop(List<String> carname, int[] carmove) {
        for (int i = 0; i < carname.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) carmove[i]++;
            System.out.printf("%s : ", carname.get(i));
            for (int j = 0; j < carmove[i]; j++) System.out.printf("-");
            System.out.println();
        }
        System.out.println();
    }

    public List<String> winner(List<String> carname, int[] carmove) {
        List<String> winner = new ArrayList<>();
        int max = 0, maxuser = 0;
        for (int i = 0; i < carname.size(); i++) {
            if (carmove[i] > max) {
                max = carmove[i];
                maxuser = i;
            }
        }
        winner.add(carname.get(maxuser));
        for (int i = maxuser + 1; i < carname.size(); i++) {
            if (carmove[i] == max) winner.add(carname.get(i));
        }
        return winner;
    }
}