package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RandomNumberGenerator {

    RandomNumber randomNumber = new RandomNumber();

    public List<Integer> createRandomNumberList(LinkedHashMap<String, String> carList) {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomNumberList.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumberList;
    }
}
