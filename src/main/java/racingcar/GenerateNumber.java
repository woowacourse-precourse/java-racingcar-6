package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumber {

    public List<Integer> GenerateRandomNumber(List<String> players) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumbers;
    }

}
