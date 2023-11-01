package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GoStop {

    public List<String> racing(List<String> listA, int tryNum) {
        List<String> listB = new ArrayList<>();
        String bar = "";
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < listA.size(); i++) {
            listB.add(listA.get(i) + " : ");
        }
        for (int i = 0; i < tryNum; i++) {
            System.out.println();
            for (int j = 0; j < listA.size(); j++) {
                listB.set(j, listB.get(j) + plusBar(bar));
                System.out.println(listB.get(j));
            }
        }
        return listB;
    }

    public String plusBar(String bar) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            bar = bar.concat("-");
        }
        return bar;

    }
}
