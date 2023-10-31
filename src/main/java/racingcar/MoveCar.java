package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/*
 * 랜덤 숫자 추출해 전진/스탑 결정
 */
public class MoveCar {
    public int goOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
