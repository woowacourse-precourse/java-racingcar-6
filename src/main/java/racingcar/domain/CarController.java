package racingcar.domain;

import java.util.List;

public class CarController {

//- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - carControler()
//    - [ ] 주어진 횟수 - moveCount
//    - [ ] n대의 자동차 - cars[]
//    - [ ] 전진 혹은 멈추는 조건 확인 - isForward
//      - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. isForward()
//        - [ ] 0~9 사이의 무작위값 구현 - makeRandomNumbers()
//        - [ ] 4를 기준으로 전진 조건 확인  - isBiggerThanFour()
    int moveCount;
    List<String> cars;


    public CarController(int moveCount, List<String> cars) {
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public boolean isForward() {
        return false;
    }

    public int makeRandomNumbers() {
        return 0;
    }

    public boolean isBiggerThanFour() {
        return false;
    }

}
