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

    // 전진 반복하는 만큼 "-" 더하기(인자는 이전 턴의 이동 거리)
    public String countMovement(String movement) {
        if(moveCar()) {
            movement = movement + "-";
        }
        return movement;
    }

    // 이동 횟수 충족(즉 결승선 도달) 검증(인자는 턴마다의 이동 거리와 사용자 입력값)
    public boolean finishRace(String movement, int count) {
        if(movement.length() == count - 1) {
            return true;
        }
        return false;
    }
}
