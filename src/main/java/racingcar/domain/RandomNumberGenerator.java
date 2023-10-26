package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

/*    public List<Integer> collectNumbers(int carsNumber) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<carsNumber; i++) {
            int num = Randoms.pickNumberInRange(0, 9);
            numbers.add(num);
        }
        return numbers;
    }*/

    public int generateNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        return num;
    }
}