package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Movecar {
    public void print(int usercount, List<String> carname) {
        int[] carmove = new int[carname.size()];
        for (int i = 0; i < usercount; i++) {
            go_or_stop(carname, carmove);
        }
        winner(carname, carmove);
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

    public void winner(List<String> carname, int[] carmove) {
        int max = 0, maxuser = 0;
        for (int i = 0; i < carname.size(); i++) {
            if (carmove[i] > max) {
                max = carmove[i];
                maxuser = i;
            }
        }
        System.out.printf("최종 우승자 : %s",carname.get(maxuser));
        for (int i = maxuser + 1; i < carname.size(); i++) {
            if (carmove[i] == max) System.out.printf(", %s", carname.get(i));
        }
    }
}
