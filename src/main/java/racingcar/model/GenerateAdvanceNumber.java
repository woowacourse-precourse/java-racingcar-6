package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateAdvanceNumber {

    public static List<Integer> GenerateRandomNumber(int carCounts) {
        List<Integer> GenerateRandomNumbers = new ArrayList<>();  // 초기화
        for(int i = 0 ; i<carCounts;i++) {
            GenerateRandomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return GenerateRandomNumbers;
    }

}
