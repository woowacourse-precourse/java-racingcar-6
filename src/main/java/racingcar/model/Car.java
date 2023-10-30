package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    /* 기능 목록
    * 무작위 값을 갖는다.
    * 무작위 값이 4 이상이면 전진한다.
    * 무작위 값이 4 미만이면 멈춘다.
    * 5자 이하의 이름을 갖는다.
    * 전진 시, 이름을 출력한다.
    * */

//    1. 무작위 값 갖기
    public Integer getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

//    2. 이동 여부 결정
    public Boolean moveOrNot() {
        Integer judgementValue = this.getNumber();
        return judgementValue >= 4;
    }

//    3. 전진 시, 이름 출력
    public String getName() {
        return name;
    }
}

