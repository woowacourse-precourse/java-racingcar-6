package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Movement {
    public void forwardOrStop(String attempt, List<String> carNameList, List<String> forwardCountStr, List<Integer> forwardCountInt) {
        for (int i = 0; i < Integer.parseInt(attempt); i++) {
            //n회 시도 - 자동차 수 만큼 반복
            for (int j = 0; j < carNameList.size(); j++) {
                //전진
                forwardCountList(forwardCountStr, forwardCountInt, j);
            }
            racingStatus(carNameList, forwardCountStr);
            System.out.print("\n");
        }
    }

    public void forwardCountList(List<String> forwardCountStr, List<Integer> forwardCountInt, int j) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            forwardCountStr.set(j, forwardCountStr.get(j) + "-");
            forwardCountInt.set(j, forwardCountInt.get(j) + 1);
        }
    }

    public void racingStatus(List<String> carNameList, List<String> forwardCountStr) {
        for (int k = 0; k < carNameList.size(); k++) {
            System.out.println(String.format("%s : %s", carNameList.get(k), forwardCountStr.get(k)));
        }
    }
}
