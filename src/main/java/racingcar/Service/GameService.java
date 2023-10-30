package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FORWARD_NUMBER = 4;

    // 쉼표(,)를 기준으로 입력된 자동차 이름 분해 후 List에 저장
    public List<String> parseCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    // 자동차 별 무작위 값을 구함
    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    // 무작위 값이 4 이상일 때 전진
    private void moveForwardByRandomNumber(Car car) {
        if (pickRandomNumber() >= FORWARD_NUMBER) {
            car.moveForward(1);
        }
    }
}
