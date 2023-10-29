package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Movement {

    /**
     * 자동차 이름 수만큼 0으로 채워진 리스트 생성 후 return
     */
    public List<Integer> createMovement(List<String> names) {
        int listSize = names.size();
        List<Integer> movementList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            movementList.add(0);
        }
        return movementList;
    }

    /**
     * 4이상의 값이면 한칸 움직이게 만드는 함수
     */
    public void raceMoveOrStop(List<String> names, List<Integer> movementList) {
        for (int i = 0; i < names.size(); i++) {
            if (isMove()) {
                Integer movement = movementList.get(i);
                movement += 1;
                movementList.set(i, movement);
            }
        }
        printRace(names, movementList);
    }

    // 현재까지의 경주 현황 프린트
    private void printRace(List<String> names, List<Integer> movementList) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + "-".repeat(movementList.get(i)));
        }
        System.out.println();
    }

    // 랜덤값 생성 ( 0~4: false, 0~9: true )
    private boolean isMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
