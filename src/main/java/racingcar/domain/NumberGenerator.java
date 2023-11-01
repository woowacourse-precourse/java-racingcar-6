package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 랜덤 숫자
 */
public class NumberGenerator {
    //n은 자동차가 1대라고 가정하였을 때, 사용자가 입력한 횟수이다.
    int n;

    //전진(4이상)
    public List<Integer> Go() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int number = new Random().nextInt(9);
                numbers.add(number);
        }
        return numbers;
    }

    //멈춤(3이하)
    public void Stop() {

    }
}
