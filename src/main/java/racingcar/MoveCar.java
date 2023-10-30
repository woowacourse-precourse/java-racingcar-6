package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/*
 * 랜덤 숫자 추출해 전진/스탑 결정
 */
public class MoveCar {
    public boolean goOrStop() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
