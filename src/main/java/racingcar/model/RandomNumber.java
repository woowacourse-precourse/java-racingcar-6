package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

//자동차 이름 개수만큼 랜덤숫자를 생성
public class RandomNumber {
    private List<Integer> randomList = new ArrayList<>();
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private RandomNumber(List<Integer> list) {
        this.randomList = list;
    }

    public static RandomNumber makeRandomNumber() {
        List<Integer> tmpRandomList = new ArrayList<>();
        while (tmpRandomList.size() < 3) { // 일단 3으로 설정
            int number = pickNumberInRange(START_RANGE, END_RANGE);
            tmpRandomList.add(number);
        }
        return new RandomNumber(tmpRandomList);
    }
}