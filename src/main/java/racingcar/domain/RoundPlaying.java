package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import java.util.HashMap;

public class RoundPlaying {
    public RoundPlaying() {
    } // 테스트용 생성자
    public RoundPlaying(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            int number = createRandomNumber();
            cars.get(name) += roundScore(number);
        }
        printScore();
    }

    boolean decideToMove (int randomNumber) {
        return randomNumber >= 4;
    } // randomNumber 가 4 이상이면 true 반환

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
