package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class CarController {

//- [ ] 주어진 횟수(세트수) 동안 n대의 자동차는 전진 또는 멈출 수 있다. - carControler()
//    - [ ] 주어진 횟수(반복횟수) - moveCount
//    - [ ] n대의 자동차 - cars[]
//    - [ ] 전진 혹은 멈추는 조건 확인 - isForward
//      - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. isForward()
//        - [ ] 0~9 사이의 무작위값 구현 - makeRandomNumbers()
//        - [ ] 4를 기준으로 전진 조건 확인  - isBiggerThanFour()
//    - [ ] 1세트 경주 결과 기록후 해시맵 반환 - gameStart
//      - [ ] 결과 기록 해시맵 - resultRacing HashMap<String, Integer>
//      - [ ] 경주 이후 결과 해시맵 에 기입.


    List<String> cars;
    HashMap<String, Integer> racingResult = new HashMap<>();


    public CarController(List<String> cars) {
        this.cars = cars;
    }

    public HashMap<String, Integer> gameStart() {
        return null;
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
