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
     * 각각의 자동차가 랜덤값을 생성하고
     * 움직일지 말지 결정하고
     * 한 사이클의 진행상황을 프린트 하는 함수
     */
    public void eachRace(List<String> names, List<Integer> movementList) {
        for (int index = 0; index < names.size(); index++) {
            int random = isMove();
            int moveOrStop = raceMoveOrStop(movementList.get(index), random);
            movementList.set(index, moveOrStop);
        }
        printRace(names, movementList);
    }

    // 랜덤값 생성 ( 0~4: false, 0~9: true )
    public int isMove() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 4이상의 값이면 한칸 움직이게 만드는 함수
    public int raceMoveOrStop(int movementIndex, int random) {
        if (random >= 4) {
            movementIndex += 1;
        }
        return movementIndex;
    }

    // 현재까지의 경주 현황 프린트
    public void printRace(List<String> names, List<Integer> movementList) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + "-".repeat(movementList.get(i)));
        }
        System.out.println();
    }
}