package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movecar {
    public void print(int usercount, List<String> carname) {
        for (int i = 0; i < usercount; i++) {
            go_or_stop(carname);
        }
    }

    public void go_or_stop(List<String> carname) {
        int index = 0;
        for (int i = 0; i < carname.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carname.set(i, carname.get(i) + '-');
            }
            if (carname.get(i).contains("-") == true) {
                index = carname.get(i).indexOf("-");
                System.out.printf("%s : %s\n", carname.get(i).substring(0, index), carname.get(i).substring(index));
            }
            if (carname.get(i).contains("-") == false) System.out.printf("%s : \n", carname.get(i));
        }
        System.out.println();
    }
}
