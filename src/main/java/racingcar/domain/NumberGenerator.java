package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer>  createRandomNumber(){
        // 3개의 숫자가 담길 때까지 반복한다
        // 숫자는 어떤 수든 상관없다
        // 주어진 횟수만큼 실행할 것이다.
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(0, 9);
            numbers.add(number);
        }
        return numbers;
    }
}
