package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    List<Integer> randomNumbers = new ArrayList<>();
    List<Integer> raceNumber = new ArrayList<>();
    int randomNumber;

    public List<Integer> random(int size) {
        for (int i = 0; i < size; i++) {
            randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
    public List<Integer> compare(List<Integer> computerNumber) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) > 4) {
                raceNumber.add(raceNumber.get(i) + 1);
            }
        }
        return raceNumber;
    }
}
