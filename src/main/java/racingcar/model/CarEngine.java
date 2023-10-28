package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarEngine {

    // 자동차 전진 여부 판별
    public boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if(drive >= 4) {
            return true;
        }
        return false;
    }

    // 전진 반복하는 만큼 "-" 더하기
    public String countMovement(int count) {
        String movement = " ";
        for(int i = 1; i <= count; i++) {
            if(moveCar()) {
                movement = movement + "-";
            }
        }
        return movement;
    }

    public void finishRace() {

    }
}
