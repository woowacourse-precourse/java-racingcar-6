package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
    public String result(List<String> listA, List<String> listB) {
        String winner = "";
        List<Integer> listC = new ArrayList<>();
        for (int i = 0; i < listB.size(); i++) {
            listC.add(listB.get(i).length() - listB.get(i).replace("-", "").length());
        }
        int max = 0;
        max = Collections.max(listC);
        for (int i = 0; i < listB.size(); i++) {
            if (listC.get(i).equals(max)) {
                winner += listA.get(i) + ", ";
            }
        }
        return winner.substring(0, winner.length() - 2);
    }
}
