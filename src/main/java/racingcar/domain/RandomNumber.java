package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public static List<Integer> raceNumber = new ArrayList<>();
    int randomNumber;

    public void initRace(int size) {
        for (int i = 0; i < size; i++) {
            raceNumber.add(i, 0);
        }
    }

    public void random(int size) {
        for (int i = 0; i < size; i++) {
            randomNumber = Randoms.pickNumberInRange(0, 9);
            //System.out.println(randomNumber);
            if (randomNumber > 3)
                raceNumber.add(i, raceNumber.get(i) + 1);
        }
    }
}
