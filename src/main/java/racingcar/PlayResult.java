package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayResult {
    public void getResult(String[] names, String[] results){
        for (int i = 0; i < names.length; i++) {
            int r = Randoms.pickNumberInRange(0, 9);
            if (r >= 4)
                results[i] += "-";
            System.out.println(results[i]);
        }
    }
}
